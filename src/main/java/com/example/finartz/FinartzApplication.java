package com.example.finartz;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import com.example.finartz.controller.AirportController;
//import com.example.finartz.controller.IndexController;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages= "com.example.finartz")
@EnableJpaRepositories("com.example.finartz.repository")
public class FinartzApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(FinartzApplication.class, args);
	}

}
