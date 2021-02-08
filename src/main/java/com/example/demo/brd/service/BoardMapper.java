package com.example.demo.brd.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {
	public int insertMany(List<Board> list);
	
	public int insert(Board board);

	public Board selectBoardDetail(int num);

	public int update(Board board);

	public int delete(Board board);

	public List<Board> list();

}
