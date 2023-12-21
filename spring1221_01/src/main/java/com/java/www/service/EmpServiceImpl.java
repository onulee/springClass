package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper empMapper;
	
	@Override
	public ArrayList<EmpDto> list() {
		// 사원정보 가져오기
		ArrayList<EmpDto> list = empMapper.list();
		return list;
	}

	@Override
	public ArrayList<EmpDeptDto> list2() {
		// 사원정보 가져오기
		ArrayList<EmpDeptDto> list = empMapper.list2();
		return list;
	}

	@Override
	public ArrayList<MemBoardDto> list3() {
		// 사원정보 가져오기
		ArrayList<MemBoardDto> list = empMapper.list3();
		return list;
	}

}
