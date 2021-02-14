package com.example.demo.brd.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {

	public List<Board> selectAll();

	public int insert(Board board);

	public int update(Board board);

	public int delete(Board board);

	public int count();

	public Board selectById(int boardNum);

}
