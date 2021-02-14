package com.example.demo.shw.service;

import com.example.demo.cmm.utl.Pagination;
import com.example.demo.shw.service.Show;

import static java.util.Comparator.comparing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.cmm.utl.Util.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
public class ShowService {
	
	@Autowired ShowMapper showMapper;
	
	public int add(Show show) {
		return showMapper.insert(show);
	}
	
	public List<Show> list() {
		return showMapper.selectAll();
	}
	    
	public int count() {
		return showMapper.count();
	}
	
    public Show selectById(int showNum) {
    	return showMapper.selectById(showNum);
    }
    
	public int update(Show show) {
		return showMapper.update(show);
	}
	
	public int delete(Show show) {
		return showMapper.delete(show);
	}

}
