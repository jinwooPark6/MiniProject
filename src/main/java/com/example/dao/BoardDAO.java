package com.example.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.Board;


@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;

	public int insertBoard(Board board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<Board> selectAllBoard() {
		ArrayList<Board> bList = new ArrayList<Board>();

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.selectAllBoard();
		} catch (Exception e) {
			e.printStackTrace();
			return bList;
		}
		return bList;
	}

	public Board selectBoard(String boardSeq) {
		Board result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.selectBoard(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public int deleteBoard(String boardSeq) {
		int result = 0;
 
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteBoard(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public int updateBoard(Board board) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}