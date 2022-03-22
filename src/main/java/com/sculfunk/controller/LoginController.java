package com.sculfunk.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sculfunk.entity.Users;
import com.sculfunk.repository.LoginRepository;
import com.sculfunk.service.LoginService;

@Controller
public class LoginController {

	@Autowired LoginService loginService;
	
	@RequestMapping("login")
	public String login(HttpSession session,@RequestParam(name = "id") String id, @RequestParam(name = "pw") String pw) {
		
		if(loginService.login(id, pw, session)) {
			return "loginOk";
		}
		
		return "loginFail";
	}
	
	
	@RequestMapping("join")
	public String join(){
		return "join";
	}
	
	
	@RequestMapping("join.do")
	public String joinDo(HttpServletRequest request) {
		loginService.join(request);
		return "join";
	}
	
	@RequestMapping("findId")
	public String findId() {
		return "findId";
	}
	@RequestMapping("findId.do")
	public String findIdDo(@RequestParam(name="name") String name,@RequestParam(name="email") String email , Model model) {
		model.addAttribute("id",loginService.findId(name, email));
		return "findIdComp";
	}
	@RequestMapping("findPw")
	public String findpw() {
		return "findPw";
	}
	
	@RequestMapping("updatePw")
	public String updatePw() {
		return "updatePw";
	}
	
	@RequestMapping("updatePw.do")
	public String updatePwDo(@RequestParam(name="pw") String pw,HttpServletRequest request) {
		loginService.updatePw(request, pw);
		return "index";
	}
	
	
	
	
}
