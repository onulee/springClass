package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
public class BoardController {
	
	@Autowired
	BService bService;
	
	@RequestMapping("bList")
	public String bList(Model model) {
		
		ArrayList<BoardDto> list = bService.selectAll();
		model.addAttribute("list",list);
		
		return "bList";
	}

}
