package com.example.demo;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
<<<<<<< HEAD

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@SessionAttributes({"ctx","bkg","cmm"})
=======
/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"ctx","cmm","mgr","uss"})
>>>>>>> master
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired HttpSession session;
	@Autowired HttpServletRequest request;
<<<<<<< HEAD
=======
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
>>>>>>> master

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request) {
    	String ctx = request.getContextPath();
    	session.setAttribute("ctx", ctx);
<<<<<<< HEAD
    	session.setAttribute("bkg", session.getAttribute("ctx")+"/resources/bkg");
    	session.setAttribute("cmm", session.getAttribute("ctx")+"/resources/cmm");
        logger.info("Hello. This is LogManager's logger");
        return "index";
    }
    @GetMapping("/move/bkg/{page}")
    public String move(@PathVariable String page){
        logger.info("이동경로>>> bkg/"+page);
        return String.format("bkg:%s", page);
    }
}
=======
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
>>>>>>> master
