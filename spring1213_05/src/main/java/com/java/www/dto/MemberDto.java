package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter - Getter 입력
//@Setter - Setter 입력
@Data // Getter,Setter 모두 입력
@AllArgsConstructor // 전체생성자
@NoArgsConstructor  // 기본생성자
public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private Timestamp mdate;
	

}
