package com.jiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.jiao.dao")
public class SpringbootStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudentsApplication.class, args);
	}

}
