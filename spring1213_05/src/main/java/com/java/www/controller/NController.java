package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.www.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("notice")
public class NController {
	
	@RequestMapping(method=RequestMethod.GET,value="noticeList")
	public String noticeList() {
		return "notice/noticeList";
	}
	
	@RequestMapping("noticeInsert")
	public String noticeInsert() {
		return "notice/noticeInsert";
	}
	@RequestMapping("doNoticeInsert")
	public String doNoticeInsert(HttpServletRequest request, Model model) {
		//btitle,bcontent,bfile
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bfile = request.getParameter("bfile");
		System.out.println("controller btitle : "+btitle);
		System.out.println("controller bcontent : "+bcontent);
		System.out.println("controller bfile : "+bfile);
		Timestamp bdate = new Timestamp(System.currentTimeMillis());
		BoardDto bdto = BoardDto.builder().btitle(btitle).bcontent(bcontent)
				.bdate(bdate).bfile(bfile).build();
//		model.addAttribute("btitle",btitle);
//		model.addAttribute("bcontent",bcontent);
//		model.addAttribute("bdate",bdate);
//		model.addAttribute("bfile",bfile);
		model.addAttribute("bdto",bdto);
		
		return "notice/noticeView";
	}
	
	@RequestMapping("noticeView") //GetMapping,PostMapping 둘다 가능
	public String noticeView() {
		return "notice/noticeView";
	}

}
