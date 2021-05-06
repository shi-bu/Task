package com.example.demo.memo.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.memo.repository.Memo;

@Mapper
public interface MemoMapper {

	public List<Memo> selectAll();
	public Memo search(Memo title);
	public Memo selectOne(int id);
	public void insert(Memo memo);
	public void update(Memo memo);
	public void delete(int id);
}
