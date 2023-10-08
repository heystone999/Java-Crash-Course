package com.stone.module5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Module5Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Module5Application.class, args);
	}

//	把url路径和磁盘路径做一个映射
//	http://localhost:8080/play/xxx => static/play
//	http://localhost:8080/play/xxx => d:/aaa
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//					url路径 				磁盘路径
		registry.addResourceHandler("/play/**").addResourceLocations("file:"+videoPath);
		registry.addResourceHandler("/img/**").addResourceLocations("file:/Users/stone/stone_code/Java_code/img/");
	}

	@Value("${video-path}")
	private String videoPath;

}
