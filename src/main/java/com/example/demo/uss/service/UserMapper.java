package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;

@Repository
public interface UserMapper {

	public int insert(User u);
	public User login(User u);
	public List<User> selectAll(Pagination page);
	public List<User> list();
	public int update(User u);
	public int delete(User u);
	public User selectById(String userid);
    public List<User> selectAll();
    public int count(Box<String> bx);
}