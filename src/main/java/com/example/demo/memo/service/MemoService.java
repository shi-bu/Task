package com.example.demo.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.memo.repository.Memo;
import com.example.demo.memo.repository.mybatis.MemoMapper;

@Service
public class MemoService implements MemoMapper {

	@Autowired
	private MemoMapper memoMapper;
	
	@Override
	public List<Memo> selectAll() {
		
		return memoMapper.selectAll(); 
	}
	
	@Override
	public Memo search(String title) {
		
		return memoMapper.search(title); 
	}
	
	@Override
	public Memo selectOne(int id) {
		
		return memoMapper.selectOne(id);
	}
	
	@Override
	public boolean insert(Memo memo) {
		
		return memoMapper.insert(memo);
	}
}
