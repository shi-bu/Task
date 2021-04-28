package com.example.demo.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.memo.repository.Memo;
import com.example.demo.memo.repository.mybatis.MemoMapper;

@Service
public class MemoService {

	@Autowired
	private MemoMapper memoMapper;
	

	public List<Memo> selectAll() {
		
		return memoMapper.selectAll(); 
	}
	

	public Memo selectOne(int id) {
		
		return memoMapper.selectOne(id); 
	}
}
