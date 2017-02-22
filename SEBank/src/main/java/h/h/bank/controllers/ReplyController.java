package h.h.bank.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import h.h.bank.repository.ReplyRepository;
import h.h.bank.vo.Board;
import h.h.bank.vo.Reply;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyRepository rr;
	
	@Autowired
	HttpSession se;

	@RequestMapping(value = "/insertR", method = RequestMethod.POST)
	public String write(Reply r) {
		int bnum = r.getBoardnum();
		r.setCustid((String)se.getAttribute("loginId"));
		intResult("댓글  등록", rr.insert(r));
		return "redirect:/selectB?boardnum="+bnum;
	}
	
	@RequestMapping(value = "/updateR", method = RequestMethod.POST)
	public String modify(Reply r) {
		intResult("댓글 수정", rr.update(r));
		return "redirect:/selectB";
	}
	
	@RequestMapping(value = "/deleteR", method = RequestMethod.POST)
	public String delete(int rnum) {
		intResult("댓글  삭제", rr.delete(rnum));
		return "redirect:/selectB";
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
		se.setAttribute("resultR", r);
	}
}
