package com.example.demo.uss.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class User {
	private String userid;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String birthday;
	private String gender;

}
