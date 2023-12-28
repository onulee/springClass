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
	public String loginCheck(MemberDto mdto) {
		MemberDto memberDto = memberMapper.loginCheck(mdto);
		//id,pw를 가지고 회원을 찾으면 - 사용불가, 없으면 - 사용가능
		String result ="";
		if(memberDto!=null) {
			result="로그인성공";
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		else result="로그인실패";
		
		return result;
	}

}
