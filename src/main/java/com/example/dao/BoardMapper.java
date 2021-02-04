package com.example.dao;

import java.util.ArrayList;

import com.example.domain.Board;

public interface BoardMapper {

	public int insertBoard(Board board);
	public ArrayList<Board> selectAllBoard();
	public Board selectBoard(String boardSeq);
	public int deleteBoard(String boardSeq);
	public int updateBoard(Board board);
}