package com.sculfunk.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sculfunk.entity.Users;

@Repository
public class LoginRepository {
	@Autowired
	private EntityManager em;
	//findOne
	public Users findOne(String id) {
		return em.find(Users.class, id);
	}
	
	//회원가입
	public void join(Users user) {
		em.persist(user);
	}
	
	//로그인
	public List<Users> login(String id,String pw) {
		return em.createQuery("SELECT u FROM Users u WHERE u.id = :id AND u.pw = :pw", Users.class)
				.setParameter("id",id ).setParameter("pw", pw).getResultList();
	}
	
	//아이디찾기
	public String findId(String name,String email) {
		return em.createQuery("SELECT u.name FROM Users u WHERE u.name = :name AND u.email = :email ",String.class)
				.setParameter("name",name).setParameter("email", email).getSingleResult();
	}
	
	//Id 중복검사
	public boolean checkId(String id) {
		if(em.find(Users.class, id)!=null) {
			//중복됨
			return false;
		} else {
			//중복안됨
			return true;
		}
	}
	
	//email 중복검사
	public boolean checkEmail(String email) {
		if(em.createQuery("SELECT u.email FROM Users u WHERE u.email = :email",Users.class).setParameter("email", email)
				.getSingleResult()!=null) {
			//중복됨
			return false;
		} else {
			//중복안됨
			return true;
		}
	}
	
}
