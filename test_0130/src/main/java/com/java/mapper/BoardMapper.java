package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체가져오기
	public ArrayList<BoardDto> selectAll2(String[] locals);

	//게시글 1개 가져오기
	public BoardDto selectOne(int bno);

	//이전글
	public BoardDto preSelectOne(int bno);

	//다음글
	public BoardDto nextSelectOne(int bno);

	//게시글 쓰기 저장
	public void insert(BoardDto bdto);
}
