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
	
	@GetMapping("/search")
	public String memoSearch(@RequestParam("title")String title, Model model) {
		
		Memo memo = memoService.search(title);
		
		model.addAttribute("memoId", memo.getMemoId());
		model.addAttribute("title", memo.getTitle());
		model.addAttribute("content", memo.getContent());
		
		return "searchResult";
	}
	
	@GetMapping("/details")
	public String memoDetails(@RequestParam("memoId")String str, Model model) {
		
		int id = Integer.parseInt(str);
		Memo memo = memoService.selectOne(id);
		
		model.addAttribute("memoId", memo.getMemoId());
		model.addAttribute("title", memo.getTitle());
		model.addAttribute("content", memo.getContent());
		
		return "memoDetails";
	}
	
	@GetMapping("/create")
	public String memoAddDisplay() {
		return "create";
	}
	
	@PostMapping("/create")
	public String memoAdd(@RequestParam("title")String title, @RequestParam("content")String content, Model model) {
		
		Memo memo = new Memo();
		memo.setTitle(title);
		memo.setContent(content);
		
		//resultは処理の成功/失敗確認に後で使用する
		boolean result = memoService.insert(memo);
		
		return "redirect:/index";
	}
}
