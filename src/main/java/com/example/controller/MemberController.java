package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.User;
import com.example.service.MemberService;



@Controller
public class MemberController {

	@Autowired
	MemberService mService;

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(User user, Model model) {

		int result = mService.insertUser(user);

		if (result == 0) {
			model.addAttribute("message", "같은 아이디가 있습니다.");
			return "index";
		}

		return "login";
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(User user, Model model, HttpSession session) {

		User result=mService.loginUser(user);
		
		if(result==null){
			model.addAttribute("message","ID나PW가 틀립니다.");
			return "login";
		}else{
			session.setAttribute("loginId", result.getId());
			return "mypage";
		}
	
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(User user, Model model, HttpSession session) {
//로그인 값을 계속 가지고 있는 Session TEST
		
		System.out.println((String)session.getAttribute("loginId"));
		
		return "mypage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(User user, Model model, HttpSession session) {
		session.invalidate();		
//session.setAttribute("loginId",null); 으로 해줘도 된다.
		return "login";
	}

}