package com.example.mybolg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
@EnableTransactionManagement
@MapperScan("mybatis") //配置mybatis包扫描
*/
@SpringBootApplication
@RestController
public class MybolgApplication {

	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("/login");
		return mv;
	}

	public static void main(String[] args) {
		SpringApplication.run(MybolgApplication.class, args);
	}

}
