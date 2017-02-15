package h.h.bank.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import h.h.bank.repository.CustomerRepository;
import h.h.bank.vo.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerRepository cr;
	
	@Autowired
	HttpSession se;
	
	@Autowired
	HttpServletResponse response;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "customer/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String id, String password, Model model) {
		Customer c = cr.select(id, password);
		if  (c!=null) {
			se.setAttribute("loginC",c);
			se.setAttribute("loginId",c.getCustid());
			se.setAttribute("loginName",c.getName());
	//		model.addAttribute("loginId",c.getCustid());
	//		model.addAttribute("loginName",c.getName());
	//		System.out.println("성공");
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model) {
		Customer c = (Customer) se.getAttribute("loginC");
		String name = (String) c.getName();
		String id= (String) c.getCustid();
		se.invalidate();
		se.setAttribute("logoutresult", name+"("+id+")님 안녕~~~~~");
		return "redirect:/";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "customer/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Customer c, Model model) {
		int result = cr.insert(c);
		return "index";
//		try {
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			switch(result) {
//	         case 0:
//	            out.println("<html><head><script>alert('실패');"
//	                  + "location.href='customer/join.jsp';</script></head></html>");
//	            out.flush(); 
//	            break;
//	         case 1:
//	            out.println("<html><head><script>alert('성공');"
//	            		 + "location.href='index.jsp';</script></head></html>");
//	            out.flush();
//	            break;
//	         }	
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
