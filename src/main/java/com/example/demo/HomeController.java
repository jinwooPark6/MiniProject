package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"ctx","cmm","mgr","uss"})
public class HomeController {
	@Autowired HttpSession session;
	@Autowired HttpServletRequest request;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request) {
    	String ctx = request.getContextPath();
    	session.setAttribute("ctx", ctx);
    	session.setAttribute("cmm", ctx+"/resources/cmm");
    	session.setAttribute("mgr", ctx+"/resources/sym/mgr");
    	session.setAttribute("stu", ctx+"/resources/uss");
        logger.info("Project Initialized ... ");
        
        return "index";
    }
    
    @GetMapping("/user/{page}")
    public String user(@PathVariable String page) {
        logger.info("이동 파일: " + page);
        return String.format("user:%s", page);
    }
    
    
    @GetMapping("/mgr/{page}") 
    public String manager(@PathVariable String page) {
        logger.info("이동 파일: " + page);
        return String.format("mgr:%s", page);
    }
    

  
	
}