package com.example.demo.memo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Memo> findAll() {
		
		String query = "SELECT"
			+ " id,"
			+ " title,"
			+ " content"
			+ " FROM memo";
		
		List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
		
		List<Memo> memos = new ArrayList<>();
		
		for (Map<String, Object> map: result) {
			
			Memo memo = new Memo();
			
			memo.setMemoId((Integer)map.get("id"));
			memo.setTitle((String)map.get("title"));
			memo.setContent((String)map.get("content"));
			
			memos.add(memo);
		}
		
		return memos;
	}
	
	public Map<String, Object> findOne(int id) {
		
		String query = "SELECT"
			+ " id,"
			+ " title,"
			+ " content"
			+ " FROM memo"
			+ " WHERE id = ?";
		
		Map<String, Object> memo = jdbcTemplate.queryForMap(query, id);
		
		return memo;
	}
}
