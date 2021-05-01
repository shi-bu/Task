package com.example.demo.memo.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.memo.repository.Memo;

@Mapper
public interface MemoMapper {

	public List<Memo> selectAll();
	public Memo search(String title);
	public Memo selectOne(int id);
	public boolean insert(Memo memo);
}
