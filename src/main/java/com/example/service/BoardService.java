package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.Board;


@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;

	public int insertBoard(Board board) {
		return bdao.insertBoard(board);
	}

	public ArrayList<Board> selectAllBoard() {
		return bdao.selectAllBoard();
	}

	public Board selectBoard(String boardSeq) {
		return bdao.selectBoard(boardSeq);
	}
	
	public int deleteBoard(String boardSeq) {
		return bdao.deleteBoard(boardSeq);
	}
	
	public int updateBoard(Board board) {
		return bdao.updateBoard(board);
	}
}