package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override //게시글 전체 가져오기
	public ArrayList<BoardDto> bList() {
		ArrayList<BoardDto> list = boardMapper.bList();
		return list;
	}

	@Override //게시글 1개 가져오기
	public BoardDto selectOne(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override //게시글 파일저장
	public void bInsert(BoardDto bdto) {
		boardMapper.bInsert(bdto);
	}

}
