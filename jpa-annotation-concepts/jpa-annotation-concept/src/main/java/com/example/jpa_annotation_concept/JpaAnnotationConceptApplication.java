package com.example.jpa_annotation_concept;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaAnnotationConceptApplication {

	private final EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAnnotationConceptApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			Employee employee = Employee.builder().name("Ranjit Nayak").description("He is a good Employee")
					.salary(BigDecimal.valueOf(10000.98)).status(EmployeeStatus.ACTIVE).build();

			Employee emp = repository.save(employee);
			// Employee savedEmployee =
			// repository.findById("ae45745e-b9b1-45a6-8df1-7c7089f42b7e").orElseThrow();
			Employee savedEmployee = repository.findById(emp.getId()).orElseThrow();

			savedEmployee.setName("Ankit kumar");
			savedEmployee.setDescription("he is a good boy");

			repository.save(savedEmployee);

		};
		
	}

}
