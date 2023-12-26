package com.java.www.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class BController {

	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("notice")
	public String notice(Model model) {
		//page 가지고 와야 함.
		//service연결 - list
		List<BoardDto> list = bService.selectAll();
		//model전송
		model.addAttribute("list",list);
		return "customer/notice";
	}
	
	@GetMapping("notice_view") //게시글 1개 가져오기
	public String notice_view(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("bController notice_view bno : "+bno);
		//service연결 - dto
		Map<String, Object> map = bService.selectOne(bno);
		//model전송
		model.addAttribute("map",map);
		return "customer/notice_view";
	}
	
	//ajax 댓글 입력
	@PostMapping("BCommentInsert")
	@ResponseBody //데이터 전송
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		System.out.println("BController BCommentInsert cpw : "+cdto.getCpw());
		System.out.println("BController BCommentInsert cpw : "+cdto.getCcontent());
		System.out.println("BController BCommentInsert bno : "+cdto.getBno());
		//id추가
		cdto.setId((String) session.getAttribute("session_id"));
		
		//db에 저장된 댓글 1개 가져오기 - cno,cdate가 포함되어 있음.
		BCommentDto bCommentDto = bService.BCommentInsert(cdto);
		
		return bCommentDto;
	}
	
	
	
	
}
