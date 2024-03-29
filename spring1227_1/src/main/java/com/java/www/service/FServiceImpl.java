package com.java.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.GalleryListDto;
import com.java.www.dto.IncomeDto;
import com.java.www.mapper.IncomeMapper;

@Service
public class FServiceImpl implements FService {

	@Autowired IncomeMapper incomeMapper;
	
	@Override //매출액 가져오기
	public List<IncomeDto> incomeSelect(String cyear) {
		//db연결
		List<IncomeDto> list = incomeMapper.incomeSelect(cyear);
		return list;
	}

	@Override //갤러리 1개 데이터 저장
	public void insertGallery(GalleryListDto galleryListDto) {
		incomeMapper.insertGallery(galleryListDto);
		
	}

}
