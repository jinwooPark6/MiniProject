package com.example.demo.uss.web;
import static com.example.demo.cmm.utl.Util.*;
import static java.util.stream.Collectors.*;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.service.CommonMapper;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.uss.service.User;
import com.example.demo.uss.service.UserMapper;
import com.example.demo.uss.service.UserService;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired UserService userService;
    @Autowired CommonMapper commonMapper;
    @Autowired Pagination page;
    @Autowired Box<String> bx;
    @Autowired UserMapper userMapper;
   
    @PostMapping("/login")
    public Map<?,?> login(@RequestBody User u){
        var map = new HashMap<>();
        User result = userMapper.login(u);
        map.put("message", result!=null?"SUCCESS":"FAILURE");
        map.put("sessionUser", result);
        return map;
    }
    /*
    @GetMapping("/{userid}")
    public Student profile(@PathVariable String userid){
        return studentMapper.selectById(userid);
    }
    */
    @GetMapping("/list/{pageSize}/{pageNum}")
    public Map<?,?> list(@PathVariable String pageSize, 
    					@PathVariable String pageNum){
    	logger.info("User List Execute ...");
    	var map = new HashMap<String,String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.USERS);	
    	var page = new Pagination(
				Table.USERS.toString(), 
				integer.apply(pageSize),
				integer.apply(pageNum),
				commonMapper.totalCount(map))
				;
    	var map2 = new HashMap<String, Object>();
    	map2.put("list", userService.list(page));
    	map2.put("page", page);
        return map2;
    }
    @GetMapping("/page/{pageSize}/{pageNum}/selectAll")
    public List<?> selectAll(@PathVariable String pageSize, 
    					@PathVariable String pageNum){
    	logger.info("Students List Execute ...");
    	var map = new HashMap<String,String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.USERS);	
        return userMapper.selectAll(new Pagination(
				Table.USERS.toString(), 
				integer.apply(pageSize),
				integer.apply(pageNum),
				commonMapper.totalCount(map)));
    }
    
    @PutMapping("")
    public Messenger update(@RequestBody User u){
        return userMapper.update(u)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @DeleteMapping("")
    public Messenger delete(@RequestBody User u){
    	logger.info("Users Deleted Execute ...");
        return userMapper.delete(u) ==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    
    @GetMapping("/count")
    public String count() {
    	logger.info(String.format("Count Users ..."));
    	var map = new HashMap<String,String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.USERS);	
    	return string.apply(commonMapper.totalCount(map));
    }
   
}