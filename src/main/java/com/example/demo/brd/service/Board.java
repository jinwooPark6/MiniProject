package com.example.demo.brd.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @Lazy @AllArgsConstructor @NoArgsConstructor
public class Board {
	private int num;
	private String title, content, writer;
	private LocalDateTime insertTime;
}
