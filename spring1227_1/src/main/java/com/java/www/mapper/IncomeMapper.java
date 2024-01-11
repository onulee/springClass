package com.java.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.GalleryListDto;
import com.java.www.dto.IncomeDto;

@Mapper
public interface IncomeMapper {

	//매출액 가져오기
	List<IncomeDto> incomeSelect(String cyear);

	//갤러리 1개 데이터 저장
	void insertGallery(GalleryListDto galleryListDto);

}
