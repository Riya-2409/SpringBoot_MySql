package com.bridgelabz.employeeaayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EntityScan("com.bridgelabz.employeeaayrollapp.model")
@EnableJpaRepositories("com.bridgelabz.employeeaayrollapp.repository")
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		String environment = context.getEnvironment().getProperty("environment");
		log.info("Employee Payroll Application has started successfully in enviroment: {}",environment );
	}
}
