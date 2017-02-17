package h.h.bank.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import h.h.bank.repository.BoardRepository;
import h.h.bank.vo.Board;

@Controller
public class BoardController {

	@Autowired
	BoardRepository br;

	@Autowired
	HttpSession se;

	@RequestMapping(value = "/insertB", method = RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}

	@RequestMapping(value = "/insertB", method = RequestMethod.POST)
	public String write(Board b) {
		intResult("새 글 등록", br.insert(b));
		return "redirect:/main";// *****
	}

	@RequestMapping(value = "/selectB", method = RequestMethod.GET)
	public String read(int boardnum) {
		se.setAttribute("readB", br.select(boardnum));
		br.addHits(boardnum);
		return "board/read";
	}

	@RequestMapping(value = "/updateB", method = RequestMethod.GET)
	public String modifyForm(int boardnum) {
		return "board/modify";
	}

	@RequestMapping(value = "/updateB", method = RequestMethod.POST)
	public String modify(Board b) {
		intResult("새 글 등록", br.update(b));
		return "redirect:/main"; // *****
	}

	@RequestMapping(value = "/deleteB", method = RequestMethod.GET)
	public String delete(Board b) {
		intResult("새 글 등록", br.delete(b));
		return "redirect:/main"; // *****
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String blist() {
		se.setAttribute("blist", br.blist());
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
		se.setAttribute("result", r);
	}

	private void stringResult(String result) {
		se.setAttribute("result", result);
	}
}
