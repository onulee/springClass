package com.java.www.service;

import org.springframework.stereotype.Component;

@Component
public class PServiceImpl implements PService {

	@Override
	public void execute() {
		System.out.println("1B 연필로 그림을 그립니다.");
	}

}
