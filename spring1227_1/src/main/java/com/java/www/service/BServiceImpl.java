package com.java.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class BServiceImpl implements BService {

	@Autowired BoardMapper boardMapper;
	@Autowired HttpSession session;
	
	@Override //공지사항 전체가져오기
	public List<BoardDto> selectAll() {
		List<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override //게시글 1개 가져오기
	public Map<String, Object> selectOne(int bno,HttpServletRequest request,
			HttpServletResponse response) {
		//게시글 1개 가져오기
		BoardDto bdto = boardMapper.selectOne(bno);
		
		//조회수 중복방지
	    Cookie oldCookie = null;
	    //최초 확인 - 쿠키 전체 가져옴.
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	           if (cookie.getName().equals("readView")) {
	        	    System.out.println("readView가 있음.");
	                oldCookie = cookie;
	           }
	        }
	    }//
	    
	    if (oldCookie != null) {
	    	//oldCookie 에 해당 bno가 있는지 확인
	        if (!oldCookie.getValue().contains("["+ bno +"]")) {
	        	//조회수 증가
	    		boardMapper.bhit(bno);
	            oldCookie.setValue(oldCookie.getValue() + "_[" + bno + "]");
	            oldCookie.setPath("/");
	            oldCookie.setMaxAge(60 * 60 * 24);
	            response.addCookie(oldCookie);
	        }
	    } else {
	    	//쿠키가 존재하지 않을 경우
	    	//조회수 증가
    		boardMapper.bhit(bno);
	        Cookie newCookie = new Cookie("readView", "[" + bno + "]");
	        newCookie.setPath("/");
	        newCookie.setMaxAge(60 * 60 * 24);
	        response.addCookie(newCookie);
	        System.out.println(newCookie);
	    }
		
		
		// 하단댓글 모두 가져오기
		List<BCommentDto> bCommentlist = boardMapper.bCommentSelectAll(bno);
		
		//Map전송
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("bCommentlist", bCommentlist);
		
		return map;
	}

	@Override //댓글1개 저장 후 댓글 1개 가져오기
	public BCommentDto bCommentInsert(BCommentDto cdto) {
		//session_id를 cdto의 id에 저장
		cdto.setId((String)session.getAttribute("session_id"));
		
		//댓글1개 저장 - cno,cdate
		boardMapper.bCommentInsert(cdto); //댓글폼에서 입력한 내용을 저장시킴
		System.out.println("bCommentInsert cno : "+cdto.getCno());
		System.out.println("bCommentInsert cdate : "+cdto.getCdate());
		
		//댓글1개 가져오기
		//BCommentDto bCommentDto = boardMapper.bCommentSelectOne(cdto.getCno()); 
		
		return cdto;
	}

	@Override //댓글삭제
	public String BCommentDelete(int cno) {
		String result="";
		int re = boardMapper.bCommentDelete(cno);
		return result+re;
	}

	@Override //댓글수정저장
	public BCommentDto BCommentUpdate(BCommentDto cdto) {
		//session_id를 cdto의 id에 저장
		cdto.setId((String)session.getAttribute("session_id"));
		//수정저장
		boardMapper.BCommentUpdate(cdto);
		//댓글1개 가져오기
		BCommentDto bCommentDto = boardMapper.bCommentSelectOne(cdto.getCno());
		
		return bCommentDto;
	}

	

	

}
