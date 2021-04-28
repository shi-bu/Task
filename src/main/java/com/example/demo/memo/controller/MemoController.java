package com.example.demo.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.memo.repository.Memo;
import com.example.demo.memo.service.MemoService;

@Controller
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@GetMapping("/index")
	public String getIndex(Model model) {
		
		List<Memo> memos = memoService.selectAll();
		model.addAttribute("memos", memos);
		
		return "index";
	}
	
	@PostMapping("/memo")
	public String memoSearch(@RequestParam("memoId")String str, Model model) {
		
		int id = Integer.parseInt(str);
		
		Memo memo = memoService.selectOne(id);
		
		model.addAttribute("memoId", memo.getMemoId());
		model.addAttribute("title", memo.getTitle());
		model.addAttribute("content", memo.getContent());
		
		return "searchResult";
	}
}
