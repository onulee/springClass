package com.java.www.controller;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MController {

	@GetMapping("member/memberInsert")
	public String memberInsert(Model model) {
		return "member/memberInsert";
	}
	
	@GetMapping("member/login")
	public String login(Model model) {
		return "member/login";
	}
	
	@PostMapping("member/doLogin")
	public String doLogin(@RequestParam("id") String id,
			String pw,
			@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("controller id : "+id);
		System.out.println("controller pw : "+pw);
		System.out.println("controller 게시글 번호 : "+bno);
		
		
		return "/index";
	}
	
	
	
	@PostMapping("member/doMemberInsert")
	public String doMemberInsert(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		System.out.printf("%s,%s,%s,%s,%s,%s",id,pw,name,phone,gender,
				Arrays.toString(hobbys));
		return "member/memberView";
	}
	
	@GetMapping("member/memberUpdate")
	public String memberUpdate(Model model) {
		//request.setAttribute("id", id);
		// 현재날짜와 시간을 Timestamp파일에 저장
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto 
		= new MemberDto("bbb", "1111", "유관순", "010-1111-1111", "male", "game,golf", mdate);
		System.out.println("MemberDto id : "+mdto.getId());
		
		model.addAttribute("mdto",mdto);
		return "member/memberUpdate";
	}
	
	
//========> ModelAndView 사용법
//	@GetMapping("member/memberInsert")
//	public ModelAndView memberInsert() {
//		ModelAndView mv = new ModelAndView();
//		//id를 전달
//		String id = "admin";
//		//request.setAttribute("id", id);
//		// 현재날짜와 시간을 Timestamp파일에 저장
//	    Timestamp mdate = new Timestamp(System.currentTimeMillis());
//	    MemberDto mdto 
//	    = new MemberDto("bbb", "1111", "유관순", "010-1111-1111", "male", "game,golf", mdate);
//	    System.out.println("MemberDto id : "+mdto.getId());
//	    
//		//model.addAttribute("id",id);
//		mv.addObject("mdto",mdto);
//		mv.setViewName("member/memberInsert");
//		return mv;
//	}
	
	
}
