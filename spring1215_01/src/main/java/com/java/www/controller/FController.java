package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

@Controller
public class FController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//---- board관련 ----
	@RequestMapping("bInsert")
	public String bInsert() {
		return "bInsert";  //
	}
	@RequestMapping("bUpdate")
	public String bUpdate(BoardDto bdto, Model model) {
		model.addAttribute("bdto",bdto);
		return "bUpdate";
	}
	
	@RequestMapping("bView")
	public String bView(BoardDto bdto,MemberDto mdto, Model model) {
		System.out.println("controller bdto id : "+bdto.getId());
		System.out.println("controller mdto id : "+mdto.getId());
		model.addAttribute("bdto",bdto);
		return "bView";
	}
	
	// ------------------
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("mLogin")
	public String mLogin(String id,String pw,Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "mLogin";
	}
}
