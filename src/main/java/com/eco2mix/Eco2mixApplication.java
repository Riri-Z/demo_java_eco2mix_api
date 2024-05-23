package com.eco2mix;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eco2mix.accessingdatamongodb.StudentRepository;
import com.eco2mix.student.Student;

@SpringBootApplication
public class Eco2mixApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Eco2mixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application has started. Executing custom code...");
		studentRepository.deleteAll();

		studentRepository.save(new Student(
				1L,
				"tata",
				LocalDate.of(2022, 01, 10),
				10,
				"test@gmail.com"));

		studentRepository.save(new Student(
				2L,
				"toto",
				LocalDate.of(2023, 01, 10),
				120,
				"testo@gmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Student student : studentRepository.findAll()) {
			System.out.println(student);
		}
		System.out.println();
	}
}
