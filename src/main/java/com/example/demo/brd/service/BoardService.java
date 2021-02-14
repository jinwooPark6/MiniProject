package com.example.demo.brd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired BoardMapper boardMapper;
	
	public int write(Board board) {
		return boardMapper.insert(board);
	}

	public List<Board> list() {
		return boardMapper.selectAll();
	}

	public int count() {
		return boardMapper.count();
	}
	
	public Board selectById(int boardNum) {
		return boardMapper.selectById(boardNum);
	}

	public int update(Board board) {
		return boardMapper.update(board);
	}
	
	public int delete(Board board) {
		return boardMapper.delete(board);
	}
	
}
