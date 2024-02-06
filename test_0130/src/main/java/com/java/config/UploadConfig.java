package com.java.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer{
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
		String dateStr = sdf.format(System.currentTimeMillis());
		
		registry.addResourceHandler("/upload/**")
		.addResourceLocations("file:///c:/upload/");
		
		registry.addResourceHandler("/movie/**")
		.addResourceLocations("file:///c:/movie/");
	}

}
