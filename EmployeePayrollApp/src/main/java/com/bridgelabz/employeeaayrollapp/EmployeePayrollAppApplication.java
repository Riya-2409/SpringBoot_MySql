package com.bridgelabz.employeeaayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
	
		ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		String environment = context.getEnvironment().getProperty("environment");
		log.info("Employee Payroll Application has started successfully in enviroment: {}",environment );
	}
}
