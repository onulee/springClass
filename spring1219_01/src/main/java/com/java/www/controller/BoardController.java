package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	BService bService;
	
	@GetMapping("bList") //게시글전체 가져오기
	public String bList(Model model) {
		//db에서 가져오기
		ArrayList<BoardDto> list = bService.selectAll();
		//model 저장
		model.addAttribute("list",list);
		System.out.println("list개수 : "+list.size());
		
		return "board/bList";
	}//bList
	
	@GetMapping("bView") //게시글1개 가져오기
	public String bView(@RequestParam(defaultValue = "1") int bno,Model model) {
		System.out.println("BController bno : "+bno);
		//db에서 가져오기
		Map<String, Object> map = bService.selectOne(bno);
		//model저장
		model.addAttribute("map",map);
		
		return "board/bView";
	}//bView
	
	@GetMapping("bInsert") //글쓰기 화면보기
	public String bInsert() {
		return "board/bInsert";
	}
	
	@PostMapping("bInsert") //글쓰기 저장
	public String bInsert(BoardDto bdto,@RequestPart MultipartFile files, 
			Model model) throws Exception {
		//MultipartFile files - input type="file" name="files" name을 가져옴.
		//파일첨부의 파일이름
		if(!files.isEmpty()) { //파일첨부가 있으면
			String orgName = files.getOriginalFilename();
			System.out.println("BController 파일첨부 이름 : "+ orgName);
			long time = System.currentTimeMillis();
			String newName = time+"_"+orgName; //중복방지를 위해 새로운 이름변경
			String upload = "c:/upload/";      //파일업로드 위치
			File f = new File(upload+newName);
			files.transferTo(f);    //파일을 저장위치에 저장시킴.
			bdto.setBfile(newName); //파일이름을 BoardDto에 저장시킴
		}else {               //파일첨부가 없으면
			bdto.setBfile("");
			System.out.println("파일첨부가 없습니다.");
		}
		//db로 전송
		bService.bInsert(bdto);
		
		return "board/doBInsert";
	}//
	
	
	
	
	
	
	
	
	
}//class
