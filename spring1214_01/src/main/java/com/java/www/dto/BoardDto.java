package com.java.www.dto;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private String id;
	private int bgroup;
	private int bstep;
	private int bindent;
	private int bhit;
	private String bfile;
	
	public void setBno(String bno) {
		if(bno==null || bno.equals("")) {
			this.bno = 5;
		}else {
			this.bno =Integer.parseInt(bno);
		}
	}

}
