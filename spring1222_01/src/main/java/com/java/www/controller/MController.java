package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("login") //로그인페이지 이동
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login") //로그인 확인
	public String login(String id,String pw,Model model) {
		int result = mService.login(id,pw);
		model.addAttribute("result",result);
		return "member/doLogin";
	}
	
	@GetMapping("join01")
	public String join01() {
		return "member/join01";
	}
	
	@PostMapping("join02")
	public String join02() {
		return "member/join02";
	}
	
	@PostMapping("idCheck") //ajax
	@ResponseBody
	public String idCheck(String id,MemberDto mdto) {
		System.out.println("MController idCheck id : "+id);
		System.out.println("MController idCheck mdto pw : "+mdto.getPw());
		String result="사용가능";
		//db접근
		result = mService.idCheck(id);
		return result;
	}
	
	@PostMapping("join03")
	public String join03() {
		return "member/join03";
	}

}
