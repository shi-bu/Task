package com.example.demo.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/search")
	public String memoSearch(@ModelAttribute Memo title, Model model) {
		
		Memo memo = memoService.search(title);
		
		model.addAttribute("memo", memo);
		
		return "searchResult";
	}
	
	@GetMapping("/details/{memoId}")
	public String memoDetails(@PathVariable("memoId") int id, Model model) {
		
		Memo memo = memoService.selectOne(id);
		
		model.addAttribute("memo", memo);
		
		return "Details";
	}
	
	@GetMapping("/create")
	public String memoAddDisplay() {
		return "create";
	}
	
	@PostMapping("/create")
	public String memoAdd(@ModelAttribute Memo memo) {
		
		 memoService.insert(memo);
		
		return "redirect:/index";
	}
	
	@GetMapping("/edit/{memoId}")
	public String memoEditDisplay(@PathVariable("memoId") int id, Model model) {
		
		Memo memo = memoService.selectOne(id);
		
		model.addAttribute("memo", memo);
		
		return "edit";
	}
	
	@PostMapping("/edit/{memoId}")
	public String memoEdit(@ModelAttribute Memo memo) {
		
		memoService.update(memo);
		
		return "redirect:/details/{memoId}";
	}
	
	@GetMapping("/delete/{memoId}")
	public String memoDelete(@PathVariable("memoId") int id) {
		
		memoService.delete(id);
		
		return "redirect:/index";
	}
}
