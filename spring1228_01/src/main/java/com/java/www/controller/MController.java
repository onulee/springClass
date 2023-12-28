package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

@Controller
@RequestMapping("member")
public class MController {

	@Autowired MService mService;
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("loginCheck")
	@ResponseBody
	public String loginCheck(MemberDto mdto) {
		System.out.println("MController loginCheck id : "+mdto.getId());
		//service연결 - 로그인 확인
		String result = mService.loginCheck(mdto);
		
		
		return result; //사용가능,사용불가
	}
	
	
	
	
}
