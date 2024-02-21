package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	//게시글 전체가져오기
	ArrayList<BoardDto> selectAll2(String[] locals);

	//게시글 1개 가져오기
	Map<String, Object> selectOne(int bno);

	//게시글 쓰기 저장
	void insert(BoardDto bdto);

}
