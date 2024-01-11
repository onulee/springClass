package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoDto;
import com.java.dto.LogoutDto;
import com.java.dto.TokenDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	@GetMapping("logout")
	public String logout(Model model) {
	
		//access_token 가져오기
		System.out.println("logout session token : "+session.getAttribute("session_token"));
		
		//logout 토큰키 전송
		String logoutUrl = "https://kapi.kakao.com/v1/user/logout";
		//header
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		String authorization = "Bearer "+session.getAttribute("session_token");
		
		//url전송
		RestTemplate rt = new RestTemplate();
		//header생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", content_type);
		headers.add("Authorization", authorization);
		
		//header,body합치기
		HttpEntity<MultiValueMap<String, String>> logoutRequest = new HttpEntity<>(headers);
		
		//url,전송방식:post,데이터,String타입
		ResponseEntity<String> response = rt.exchange(logoutUrl,HttpMethod.POST,logoutRequest,String.class);
		System.out.println("로그아웃 요청값 logout response : "+response);
		System.out.println("로그아웃 요청값 body : "+response.getBody());
		
		//3-2. json데이터를 java객체로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		//Long 객체
		LogoutDto logoutDto = null;
		try {
			logoutDto = objectMapper.readValue(response.getBody(), LogoutDto.class);
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("로그아웃값 id : "+logoutDto.getId());
		
		//model로 결과값 전송
		model.addAttribute("result",logoutDto.getId());
		
		//session종료
		session.invalidate();
		
		return "logout";
	}
	
	@GetMapping("kakao/oauth") //카카오로그인
	public String oauth(String code) {
		//1. code값 리턴
		System.out.println("kakao code : "+code);
		
		//2. token키 요청
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		//header
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		//body
		String grant_type = "authorization_code";
		String client_id = "d1133ac60217e365da67d276a1313be3";
		String redirect_uri = "http://localhost:8000/kakao/oauth";
		//code = code;
		
		//url전송
		RestTemplate rt = new RestTemplate();
		//header생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", content_type);
		//body생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		//header,body합치기
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params,headers);
		
		//url,전송방식:post,데이터,String타입
		ResponseEntity<String> response = rt.exchange(tokenUrl,HttpMethod.POST,tokenRequest,String.class);
		System.out.println("토큰요청값 token response : "+response);
		System.out.println("토큰요청값 body : "+response.getBody());
		
		//2-2. json데이터를 java객체로 변경
		ObjectMapper objectMapper = new ObjectMapper();
		TokenDto tokenDto = null;
		try {
			tokenDto = objectMapper.readValue(response.getBody(), TokenDto.class);
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("토큰키값 tokenDto access_token : "+tokenDto.getAccess_token());
		
		//3. 토큰키를 전송해서 회원정보값 받기
		String tokenUrl_user = "https://kapi.kakao.com/v2/user/me";
		//header
		content_type = "application/x-www-form-urlencoded;charset=utf-8";
		String authorization = "Bearer "+tokenDto.getAccess_token();
		
		//url전송
		RestTemplate rt_user = new RestTemplate();
		//header생성
		HttpHeaders headers_user = new HttpHeaders();
		headers_user.add("Content-type", content_type);
		headers_user.add("Authorization", authorization);
				
		//header,body합치기
		HttpEntity<MultiValueMap<String, String>> tokenRequest_user = new HttpEntity<>(headers_user);
		
		//url,전송방식:post,데이터,String타입
		ResponseEntity<String> response_user = rt.exchange(tokenUrl_user,HttpMethod.POST,tokenRequest_user,String.class);
		System.out.println("사용자정보요청값 token response : "+response_user);
		System.out.println("사용자요청값 body : "+response_user.getBody());
		
		//3-2. json데이터를 java객체로 변환
		ObjectMapper objectMapper_user = new ObjectMapper();
		//tokenDto객체
		KakaoDto kakaoDto = null;
		try {
			kakaoDto = objectMapper_user.readValue(response_user.getBody(), KakaoDto.class);
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("토큰키값 kakaoDto id : "+kakaoDto.getId());
		System.out.println("토큰키값 kakaoDto Properties nickname : "+kakaoDto.getProperties().nickname);
		
		String targetUrl = "";
		if(kakaoDto != null) {
			System.out.println("카카오 로그인이 완료되었습니다.");
			session.setAttribute("session_id",kakaoDto.getId());
			session.setAttribute("session_name",kakaoDto.getProperties().nickname);
			session.setAttribute("session_token",tokenDto.getAccess_token());
			targetUrl = "redirect:/";
		}else {
			System.out.println("카카오 로그인 에러입니다.");
			targetUrl = "login";
		}
		
		return targetUrl;
	}

}
