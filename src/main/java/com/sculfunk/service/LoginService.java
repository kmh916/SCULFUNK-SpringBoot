package com.sculfunk.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sculfunk.entity.Users;
import com.sculfunk.repository.LoginRepository;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public boolean login(String id, String pw,HttpSession session) {
		List<Users> list_user = loginRepository.login(id, pw);
		
		if(list_user.size()!=1) {
			return false; 
		} else {
			session.setAttribute("user", list_user.get(0));
			return true;
		}
	}
	
	public void join(HttpServletRequest request) {
		Users user = new Users();
		HttpSession session = request.getSession();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setJoindate(LocalDateTime.now());
		user.setAddr("default");
		loginRepository.join(user);
		session.setAttribute("user", user);
	}
	
	public String findId(String name,String email) {
		return loginRepository.findId(name, email);
	}
	
	public void updatePw(HttpServletRequest request, String pw) {
		HttpSession session = request.getSession();
		Users user = loginRepository.findOne(((Users)session.getAttribute("user")).getId());
		user.setPw(pw);
	}
}
