package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.service.EmpService;

@Controller
public class FController {

	@Autowired EmpService empService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("list") //사원정보 가져오기
	public String list(Model model) {
		ArrayList<EmpDto> list = empService.list();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("list2") //사원정보 가져오기
	public String list2(Model model) {
		ArrayList<EmpDeptDto> list = empService.list2();
		model.addAttribute("list",list);
		return "list2";
	}
	
	@GetMapping("list3") //사원정보 가져오기
	public String list3(Model model) {
		ArrayList<MemBoardDto> list = empService.list3();
		model.addAttribute("list",list);
		return "list3";
	}
	
	
	
	
}
