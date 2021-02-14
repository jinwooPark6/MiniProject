package com.example.demo.brd.web;

import java.util.HashMap;
import java.util.List;
import static com.example.demo.cmm.utl.Util.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.brd.service.Board;
import com.example.demo.brd.service.BoardMapper;
import com.example.demo.brd.service.BoardService;
import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Pagination;

@RestController
@RequestMapping("/boards")
public class BoardController {
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardService boardService;
	@Autowired Pagination page;
	@Autowired BoardMapper boardMapper;
	
	@PostMapping("")
	public Messenger write(@RequestBody Board board) {
		logger.info("== 리뷰 등록 =="+board.toString());
		return boardMapper.insert(board)== 1 ? Messenger.SUCCESS : Messenger.FAILURE; 
	}
 
	@GetMapping("/list")
	public List<Board> list() {
		logger.info("== 게시판 목록 ==");
		return boardMapper.selectAll();
	}
	
	@GetMapping("/{boardNum}")
	public Board detail(@PathVariable int boardNum) {
		logger.info("== 게시글 상세 ==");
		return boardMapper.selectById(boardNum);
	}
	
	@PutMapping("")
	public Messenger update(@RequestBody Board board) {
		logger.info("== 게시글 수정 =="+board.toString());
		return boardMapper.update(board)== 1 ? Messenger.SUCCESS : Messenger.FAILURE;
	}
	
	@DeleteMapping("")
	public Messenger delete(@RequestBody Board board) {
		logger.info("== 게시글 삭제 =="+board.getTitle());
		return boardMapper.delete(board)== 1 ? Messenger.SUCCESS : Messenger.FAILURE; 
	}

	@GetMapping("/count")
	public String count() {
		logger.info(String.format("Count Boards ..."));
		var map = new HashMap<String, String>();
		return string.apply(boardMapper.count());
	}
	
}