package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Board;
import com.example.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bService;
	
	@RequestMapping(value="/goWrite",method=RequestMethod.GET)
	public String goWrite(){
		return "boardWrite";
	}
	
	@RequestMapping(value="/boardWrite",method=RequestMethod.POST)
	public String boardWrite(Board board, Model model,HttpSession session){
		
		
		if(session.getAttribute("loginId")==null){
			
			return "login";
		}else{
			String id=(String) session.getAttribute("loginId");
			board.setId(id);
			bService.insertBoard(board);
		}
		
		return "redirect:/getBoard";
	}
	
	@RequestMapping(value="/getBoard",method=RequestMethod.GET)

	public String getBoard( Model model){
		model.addAttribute("bList",bService.selectAllBoard());
		return "main";
	}
	@RequestMapping(value="/boardDetail",method=RequestMethod.GET)
	public String boardDetail(String boardSeq, Model model){
		
		model.addAttribute("board",bService.selectBoard(boardSeq));
		
		return "boardDetail";
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(String boardSeq, HttpSession session) {

		if (session.getAttribute("loginId") == null) {
			return "login";
		} else {
			String loginId = (String) session.getAttribute("loginId");
			String id = bService.selectBoard(boardSeq).getId();
			if (loginId.equals(id)) {
				bService.deleteBoard(boardSeq);
			} else {
				return "redirect:/getBoard";
			}
		}

		return "redirect:/getBoard";
	}
	
	@RequestMapping(value = "/goUpdateBoard", method = RequestMethod.GET)
	public String goUpdateBoard(String boardSeq, Model model) {
		model.addAttribute("board", bService.selectBoard(boardSeq));

		return "boardWrite";
	}
	
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(Board board, HttpSession session) {

		if (session.getAttribute("loginId") == null) {
			return "login";
		} else {
			String loginId = (String) session.getAttribute("loginId");

			String id = bService.selectBoard(board.getBoardSeq()).getId();
			if (loginId.equals(id)) {	
				bService.updateBoard(board);
			} else {
				return "redirect:/getBoard";
			}
		}
	
	}
}