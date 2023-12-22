package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MService {

	//로그인 확인
	int login(String id, String pw);

	//아이디 체크
	String idCheck(String id);

	

}
