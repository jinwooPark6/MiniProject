package com.example.demo.uss.service;
import static com.example.demo.cmm.utl.Util.*;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.cmm.utl.Pagination;

import static java.util.stream.Collectors.toList;
import static com.example.demo.cmm.utl.Util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	@Autowired DummyGenerator dummy;
    @Autowired UserMapper userMapper;
    @Autowired Box<String> bx;
    @Transactional
    public int insertMany(int count) {
    	for(int i=0; i < count; i++) {
    		userMapper.insert(dummy.makeUser());
    	}
    	return count(); 
    }

    public int count() {
    	bx.clear();
    	bx.put("COUNT_USERS", Sql.TOTAL_COUNT.toString() +  Table.USERS);
    	return userMapper.count(bx);
    }
    
    public List<User> list(Pagination page){
    	return userMapper.list().stream()
    			.sorted(comparing(User::getUserid).reversed())
    			.skip(page.getPageSize() * (page.getPageNum()-1))
    			.limit(page.getPageSize())
    			.collect(Collectors.toList());
    }
   
    
}