package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	//게시글 전체 가져오기
	@RequestMapping("bList")
	public String bList(Model model) {
		
		//게시글 전체 가져오기
		ArrayList<BoardDto> list = bService.bList();
		//model에 데이터 담기
		model.addAttribute("list",list);
		
		return "board/bList";
	}//bList
	
	//게시글 1개 가져오기
	@RequestMapping("bView")
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("bcontroller bno : "+bno);
		//service연결 - 게시글 1개 가져오기
		BoardDto boardDto = bService.selectOne(bno);
		
		model.addAttribute("bdto",boardDto);
		return "board/bView";
	}//
	
	//게시글 페이지 보기
	@RequestMapping("bInsert")
	public String bInsert() {
		//UUID uuid = UUID.randomUUID(); //난수 발생함수
		//String fileName = "a.jpg";
		//long time = System.currentTimeMillis();
		//System.out.println("uuid : "+uuid);
		//System.out.println(uuid+"_"+fileName);
		//System.out.println(time+"_"+fileName);
		
		return "board/bInsert";
	}
	
	//게시글 저장
	@RequestMapping("doBInsert")
	public String doBInsert(BoardDto bdto,@RequestPart MultipartFile files, Model model) {
		//session에서 id가져옴.
		bdto.setId((String)session.getAttribute("session_id"));
		
		if(!files.isEmpty()) { //파일첨부가 null이 아니면
			String oriFileName = files.getOriginalFilename(); //원본파일이름을 가져옴.
			//UUID
			UUID uuid = UUID.randomUUID();
			String newFileName = uuid+"_"+oriFileName;
			//파일저장 위치
			String fileUpload = "C:/upload/";
			//파일 첨부
			File f = new File(fileUpload+newFileName);
			//try-catch
			try {
				files.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//파일이름 저장
			bdto.setBfile(newFileName);
		}//if
		
		//게시글 파일저장 - bInsert
		bService.bInsert(bdto);
		
		return "board/doBInsert";
	}
	
	

}//class
