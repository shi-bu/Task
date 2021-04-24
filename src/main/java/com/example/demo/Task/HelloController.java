package com.example.demo.Task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("/hello")
	public void postRequest() {
		getHello();
	}
}
