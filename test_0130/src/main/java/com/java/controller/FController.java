package com.java.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FController {
	
	@GetMapping({"/","layout/main"})
	public String main() {
		return "layout/main";
	}
	@GetMapping("member/step03")
	public String step03() {
		return "member/step03";
	}
	
	@GetMapping("/mypage/my_list")
	public String my_list() {
		return "/mypage/my_list";
	}
	
	//체크박스 데이터 넘기기
	@GetMapping("member/checkbox")
	public String checkbox() {
		return "member/checkbox";
	}
	@PostMapping("member/send")
	public String send(String category,String search,String local,String[] locals ) {
		System.out.println("category : "+category);
		System.out.println("search : "+search);
		System.out.println("local : "+local);
		System.out.println("locals : "+ Arrays.toString(locals));
		return "member/checkbox";
	}

}
