package h.h.bank.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import h.h.bank.repository.BoardRepository;
import h.h.bank.repository.ReplyRepository;
import h.h.bank.util.FileService;
import h.h.bank.util.PageNavigator;
import h.h.bank.vo.Board;

//@SessionAttribute 를 추가하면 절차를 따짐
// 즉, 주소줄에 url을 입력해서 함부로 접근하는 거 막을 수 있음
@Controller
public class BoardController {

	@Autowired
	BoardRepository br;
	
	@Autowired
	ReplyRepository rr;

	@Autowired
	HttpSession se;
	
	final int countPerPage = 10; // page당 글 수
	final int pagePerGroup = 5; //페이지 그룹에 표시되는 그룹 수
	final String uploadPath = "/boardfile"; //나중에 어디에 upload되는지 위치 반드시 확인할 것

	@RequestMapping(value = "/insertB", method = RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}

	@RequestMapping(value = "/insertB", method = RequestMethod.POST)
	public String write(Board b, MultipartFile upload) {
		b.setCustid((String)se.getAttribute("loginId"));
		if(!upload.isEmpty()) {
			String savedFile = FileService.saveFile(upload, uploadPath);
			b.setOriginalfile(upload.getOriginalFilename());
			b.setSavedfile(savedFile);
		}
		intResult("새 글 등록", br.insert(b));
		return "redirect:/main";
	}

	@RequestMapping(value = "/selectB", method = RequestMethod.GET)
	public String read(int boardnum) {
		se.setAttribute("readB", br.select(boardnum));
		br.addHits(boardnum);
		se.setAttribute("rlist", rr.rlist(boardnum));
		return "board/read";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(int boardnum, HttpServletResponse res) {
		Board board=br.select(boardnum);
		String originalfile = board.getOriginalfile();
		//사용자 측에서 다운로드 받도록 하기 위해서 response 객체의 해더를 조작함
		try {
			//KEY와 값의 쌍 (F12로 확인)
			res.setHeader("Content-Disposition",
					"attachment;filename="+URLEncoder.encode(originalfile, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String fullpath=uploadPath+"/"+board.getSavedfile();
		ServletOutputStream fileout = null;
		FileInputStream filein = null;
		try {
			filein = new FileInputStream(fullpath);
			fileout = res.getOutputStream();
			FileCopyUtils.copy(filein, fileout);
		} catch (FileNotFoundException e) { //filein
			e.printStackTrace();
		} catch (IOException e) { //fileout
			e.printStackTrace();
		} finally {
			try {
				if(filein!=null) filein.close();
				if (fileout!=null) fileout.close(); //file이 저장이 안됨
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null; //딱히 돌아갈 곳이 없는 경우
	}

	@RequestMapping(value = "/updateB", method = RequestMethod.GET)
	public String modifyForm(int boardnum) {
		return "board/modify";
	}

	@RequestMapping(value = "/updateB", method = RequestMethod.POST)
	public String modify(Board b) {
		intResult("글 내용 수정", br.update(b));
		return "redirect:/main";
	}

	@RequestMapping(value = "/deleteB", method = RequestMethod.GET)
	public String delete(int bnum) {
		intResult("글 삭제", br.delete(bnum));
		return "redirect:/main";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String blist(
			@RequestParam(value="searchTitle", defaultValue="") String searchTitle,
			// 상단에 검색 keyword 입력하였을 때 ; 아래 page number를 누를때는 data가 없이 넘어옴
			// 아래 if (searchTitle==null) searchTitle=""; 대신에 defaultValue로 간단하게 처리 가능
			@RequestParam(value="searchText", defaultValue="") String searchText,
			@RequestParam(value="page", defaultValue="1") int page,
			// 1아니면 내가 요청한 page
			Model model) {
		
		int total = br.getCount(searchTitle, searchText);
		PageNavigator navi= new PageNavigator(countPerPage, pagePerGroup, page, total);
		se.setAttribute("blist", br.blist(searchTitle, searchText, page, countPerPage)); // loop 돌려서 출력
		
		model.addAttribute("total",total); //글 개수 출력을 위해
		model.addAttribute("searchTitle",searchTitle); // 마지막으로 검색한 데이터가 무엇인지 알기 위해
		model.addAttribute("searchText",searchText); // 마지막으로 검색한 데이터가 무엇인지 알기 위해
		model.addAttribute("navi",navi); // 페이징을 위해
		return "board/main";
	}

	private void intResult(String method, int result) {
		String r = method + " ";
		switch (result) {
		case 0:
			r += "실패~";
			break;
		case 1:
			r += "성공~";
			break;
		}
		se.setAttribute("resultB", r);
	}

	private void stringResult(String result) {
		se.setAttribute("resultB", result);
	}
}
