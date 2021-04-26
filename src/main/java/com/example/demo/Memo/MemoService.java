package com.example.demo.Memo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoService {

	@Autowired
	private MemoRepository memoRepository;
	
	public List<Memo> findAll() {
		
		return memoRepository.findAll(); 
	}
	
	public Memo findOne(int id) {
		
		Map<String, Object> map = memoRepository.findOne(id);
		
		int memoId = (Integer)map.get("id");
		String title = (String)map.get("title");
		String content = (String)map.get("content");
		
		Memo memo = new Memo();
		memo.setMemoId(memoId);
		memo.setTitle(title);
		memo.setContent(content);
		
		return memo; 
	}
}
