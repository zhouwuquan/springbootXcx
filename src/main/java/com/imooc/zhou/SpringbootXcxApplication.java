package com.imooc.zhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.imooc.zhou.dao")
public class SpringbootXcxApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootXcxApplication.class, args);
	}
}
