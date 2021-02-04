package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

public class MemberDAO {
	@Autowired
	SqlSession sqlSession;

	public int insertUser(User user) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

		try {
			result = mapper.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		return result;
	}
	
	public User loginUser(User user){
		User result=null;
		
		MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
	
		try {
			result=mapper.loginUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}

