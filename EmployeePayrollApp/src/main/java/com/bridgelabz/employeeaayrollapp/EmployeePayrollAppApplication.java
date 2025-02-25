package com.bridgelabz.employeeaayrollapp;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
=======
import org.springframework.context.ApplicationContext;
>>>>>>> UC3-LogginG_Levels_Logging_To_Console_Logging_Patterns
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
<<<<<<< HEAD
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee Payroll Application has started successfully.");
=======
		ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		String environment = context.getEnvironment().getProperty("environment");
		log.info("Employee Payroll Application has started successfully in enviroment: {}",environment );
>>>>>>> UC3-LogginG_Levels_Logging_To_Console_Logging_Patterns
	}
}
