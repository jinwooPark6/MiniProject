package com.example.dao;

import com.example.domain.User;

public interface MemberMapper {
	public int insertUser(User user);
	public User loginUser(User user);

}
