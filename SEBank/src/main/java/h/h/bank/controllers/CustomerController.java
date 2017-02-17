package h.h.bank.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import h.h.bank.repository.CustomerRepository;
import h.h.bank.vo.Customer;

@Controller
//@RequestMapping("customer/") //아래 requestmapping과 합쳐진 주소로 direct
//a href에서 customer/join이런 식으로 작성, customer 폴더안에 있는 요청이라고 인식함
//@SessionAttributes("loginC")
public class CustomerController {
	
	@Autowired
	CustomerRepository cr;
	
	@Autowired
	HttpSession se;
	
	@RequestMapping (value="/", method=RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "customer/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String id, String password, Model model) {
		Customer c = cr.login(id, password);
		if  (c!=null) {
			se.setAttribute("loginId",c.getCustid());
			se.setAttribute("loginName",c.getName());
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model) {
		String name = (String) se.getAttribute("loginName");
		String id= (String) se.getAttribute("loginId");
		se.invalidate();		
		stringResult(name+"("+id+")님 안녕~~~~~");
		return "redirect:/";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "customer/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Customer c) {
		intResult("가입",cr.insert(c));
		return "index";
	}
	
	@RequestMapping(value="/idcheck", method=RequestMethod.GET)
	public String idcheckForm() {
		return "customer/idcheck";
	}
	
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	public String idcheck(String id) {
		se.setAttribute("check", "이히히");
		se.setAttribute("id",id);
		se.setAttribute("sameid",cr.select(id));
		return "redirect:/idcheck";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(Model model) {
		String id= (String) se.getAttribute("loginId");
		model.addAttribute("loginC", cr.select(id));
		return "customer/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Customer c) {
		intResult("정보수정",cr.update(c));
		return "index";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String join(String id, String pw) {
		intResult("탈퇴",cr.delete(id, pw));
		return "index";
	}
	
	private void intResult(String method, int result) {
		String r = method+" ";
		switch (result) {
		case 0:
			r+="실패~";
			break;
		case 1:
			r+="성공~";
			break;
		}
		se.setAttribute("result", r);		
	}
	
	private void stringResult(String result) {
		se.setAttribute("result", result);
	}
}
