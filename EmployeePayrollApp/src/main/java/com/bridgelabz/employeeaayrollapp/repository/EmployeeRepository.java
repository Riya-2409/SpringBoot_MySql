package com.bridgelabz.employeeaayrollapp.repository;

import com.bridgelabz.employeeaayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}