package com.eco2mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Eco2mixApplication implements CommandLineRunner {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Eco2mixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application has started. Executing custom code...");
		System.out.println();
		System.out.println("---------PORT : " + environment.getProperty("local.server.port") + "-----------");
	}
}