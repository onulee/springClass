package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	//메일전송 객체 - 단순text발송
	@Autowired JavaMailSender mailSender;
	
	@Override //이메일 전송
	public String mailSend(String email) {
		String result = "";
		//비밀번호 생성
		String pwcode = getCreatKey();
		
		//이메일 내용입력
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);                //받는사람
		message.setFrom("onulee@naver.com"); //보내는 사람
		message.setSubject("회원가입 이메일인증 비밀번호 안내"); //제목
		message.setText("안녕하세요. 회원가입 이메일인증코드를 발송합니다.\n"+
		 "이메일 인증 코드 : "+pwcode);
		
		//이메일 발송
		mailSender.send(message);
		System.out.println("이메일 발송이 완료되었습니다.!");
		
		return "이메일 발송완료 : "+pwcode;
	}
	
	//비밀번호 생성메소드
	public String getCreatKey() {
		String pwcode ="";
		char[] charset = new char[] {
				'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i','j',
				'k','l','m','n','o','p','q','r','s','t',
				'u','v','w','x','y','z'
				};
		int idx = 0;
		for(int i=0;i<6;i++) {
			idx = (int)(Math.random()*36); //0-9까지의 랜덤숫자 생성
			pwcode += charset[idx];
		}
		System.out.println("이메일인증번호 : "+ pwcode);
		return pwcode;
	}
	

}
