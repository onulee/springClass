package com.java.www.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.www.config.AppConfig;
import com.java.www.service.PService;
import com.java.www.service.PServiceImpl;
import com.java.www.service.PServiceImpl2;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("프로그램을 시작합니다.");
		
		//1. 실제 객체선언후 메소드 사용
		//PServiceImpl pServiceImpl = new PServiceImpl();
		//pServiceImpl.execute();
		
		//1-2. 버젼2 메소드 사용
		//PServiceImpl2 pServiceImpl2 = new PServiceImpl2();
		//pServiceImpl2.execute();
		
		//2. 다형성을 이용한 객체선언후 메소드 사용
		//PService pService = new PServiceImpl();
		//pService.execute();
		
		//2-2. 버전2 메소드 사용
		//PService pService = new PServiceImpl2();
		//pService.execute();
		
		//3. spring이 직접 객체선언 한것을 주입 - xml설정 주입
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/www/config/pconfig.xml");
		//PService pService = ctx.getBean("pconfig", PService.class); 
		//pService.execute();		
		
		//3-2. spring이 직접 객체선언 한것을 주입 - java 어노테이션설정 주입
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig.class);
		PService pService = (PService)ctx2.getBean("pconfig") ; 
		pService.execute();
		

	}

}
