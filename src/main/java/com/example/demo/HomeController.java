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
@SessionAttributes({"ctx","cmm","shw"})
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired HttpSession session;
	@Autowired HttpServletRequest request;

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request) {
    	String ctx = request.getContextPath();
    	session.setAttribute("ctx", ctx);
    	session.setAttribute("cmm", session.getAttribute("ctx")+"/resources/cmm");
    	session.setAttribute("shw", session.getAttribute("ctx")+"/resources/shw");
    	
        logger.info("Project Initialized ... ");
        
        return "index";
    }
    /*
     * uss (User Service Support) 디렉토리 이동시 user 사용
     * 
    @GetMapping("/show/{page}")
    public String show(@PathVariable String page) {
        logger.info("이동 파일: " + page);
        return String.format("shw:%s", page);
    }*/
    /*
     * sym (System Manager) 디렉토리 이동시 admin 사용
     * */
    @GetMapping("/move/{dir}/{page}") 
    public String move(@PathVariable String dir, 
    						@PathVariable String page) {
        logger.info("이동 디렉토리: " + dir);
        logger.info("이동 파일: " + page);
        return String.format("%s/%s", dir, page);
    }

}