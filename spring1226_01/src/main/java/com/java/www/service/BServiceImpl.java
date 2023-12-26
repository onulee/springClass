package com.java.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired BoardMapper boardMapper;
	
	@Override //공지사항 전체가져오기
	public List<BoardDto> selectAll() {
		List<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override //게시글 1개 가져오기
	public Map<String, Object> selectOne(int bno) {
		System.out.println("BServiceImpl selectOne bno : "+bno);
		
		//map - 게시글,댓글 전체가져오기
		Map<String, Object> map = new HashMap<>();
		BoardDto bdto = boardMapper.selectOne(bno);
		List<BCommentDto> list = boardMapper.BCommentSelectAll(bno);
		map.put("bdto", bdto);
		map.put("list", list);
		return map;
	}

	@Override //db에 저장된 댓글 1개 가져오기
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		//댓글 1개 저장
		boardMapper.BCommentInsert(cdto);
		System.out.println("BServiceImpl BCommentInsert cno : "+cdto.getCno());
		
		//저장된 댓글 1개 가져오기
		BCommentDto bCommentDto = boardMapper.BCommentSelectOne(cdto.getCno());
		System.out.println("BServiceImpl bCommentDto ccontent : "+bCommentDto.getCcontent());
		return bCommentDto;
	}

}
