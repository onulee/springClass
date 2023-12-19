package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {

	//게시글전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글1개 가져오기
	Map<String, Object> selectOne(int bno);

	//글쓰기 저장
	void bInsert(BoardDto bdto);

}
