package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.User;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO mdao;

	public int insertUser(User user) {
		return mdao.insertUser(user);
	}
	public User loginUser(User user){
		return mdao.loginUser(user);
	}
	
}
