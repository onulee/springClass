package com.java.www.service;

import java.util.List;

import com.java.www.dto.GalleryListDto;
import com.java.www.dto.IncomeDto;

public interface FService {

	//매출액 가져오기
	List<IncomeDto> incomeSelect(String cyear);

	//갤러리 1개 데이터 저장
	void insertGallery(GalleryListDto galleryListDto);

}
