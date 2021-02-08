package com.example.demo.cmm.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.utl.Box;

@Service
public class CommonService {
	@Autowired CommonMapper commonMapper;
	@Autowired Box<String> bx;
	
	@Transactional
	public int generateDB() {
		var map = new HashMap<String,String>();
		List<String> l1 = Arrays.asList(
				Sql.DROP_TABLE.toString()+"show"
				)
		;
		List<String> l2 = Arrays.asList(
				Sql.CREATE_SHOWS.toString())
		;
		for(int i=0; i< l1.size(); i++) {
			map.put("DROP_TABLE", l1.get(i));
			commonMapper.dropTable(map);
			map.clear();
		}
		for(int i=0; i< l2.size(); i++) {
			map.put("CREATE_TABLE", l2.get(i));
			commonMapper.createTable(map);
			map.clear();
		}
		bx.put("TABLE_COUNT", Sql.TABLE_COUNT.toString());
		
		
		return (commonMapper.tableCount(map)!=0) ? 1: 0;
	}
	public int totalCount() {
		return 0;
	}
	public int dropTable() {
		return 0;
	}
	
}