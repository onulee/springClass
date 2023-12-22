package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {

	@Autowired MemberMapper memberMapper;
	@Autowired HttpSession session;
	
	@Override //로그인 확인
	public int login(String id, String pw) {
		int result = 0;
		//db전송
		MemberDto mdto = memberMapper.login(id,pw);
		//1개의 데이터가 있으면
		if(mdto!=null) {
			result=1;
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		System.out.println("MServiceImpl result : "+result);
		return result;
	}

	@Override //로그인 체크
	public String idCheck(String id) {
		String result = "사용불가";
		//db전송
		MemberDto mdto = memberMapper.idCheck(id);
		if(mdto==null) result="사용가능";
		
		return result;
	}

	@Override //회원가입 저장
	public String mInsert(MemberDto mdto) {
		//db전송
		memberMapper.mInsert(mdto);
		System.out.println("MServiceImpl mInsert mdto id : "+mdto.getId());
		String result="가입완료";
		
		return result;
	}

	
	
}
