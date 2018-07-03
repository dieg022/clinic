package com.dpo.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
public class ClinicsApplication 
{
	public static void main(String[] args) 
	{	
		SpringApplication.run(ClinicsApplication.class, args);
		//pruebas DE DIEGO CAMBIANDO MAIN
		//pruebas 2 de diego
	}

}
