package com.soumaya.chaussures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;   
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.service.ChaussureService;

import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication
public class ChuassuresApplication implements CommandLineRunner {

	@Autowired
	ChaussureService chaussureService;

	public static void main(String[] args) {
		SpringApplication.run(ChuassuresApplication.class, args);
	}
	
	  

	@Override
	public void run(String... args) throws Exception {
		chaussureService.saveChaussure(new Chaussure("Puma", 260.0, new Date()));
		chaussureService.saveChaussure(new Chaussure("Aldo", 250.0, new Date()));
		chaussureService.saveChaussure(new Chaussure("Nike", 500.0, new Date()));
		
	}
	 


}
