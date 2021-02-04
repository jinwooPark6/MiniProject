package com.example.domain;

import lombok.Data;

@Data
public class Board {
	
	private String boardSeq;
	private String title;
	private String content;
	private String id;
	private String indate;
	
	public Board() {
		super();
	}
	
	public Board(String boardSeq, String title, String content, String indate) {
		super();
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.id = id;
		
	}

}
