package com.bridgelabz.employeeaayrollapp.service;

import com.bridgelabz.employeeaayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeeaayrollapp.model.Employee;
import com.bridgelabz.employeeaayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    /*private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Convert Employee to EmployeeDTO
    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    // Convert EmployeeDTO to Employee
    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getSalary());
    }

    // Get All Employees as DTOs
    public List<EmployeeDTO> getAllEmployeesDTO() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Employee By ID as DTO
    public EmployeeDTO getEmployeeDTOById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Add Employee using DTO
    public EmployeeDTO addEmployeeDTO(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        Employee savedEmployee = repository.save(employee);
        return convertToDTO(savedEmployee);
    }

    // Update Employee
    public EmployeeDTO updateEmployeeDTO(Long id, EmployeeDTO employeeDTO) {
        return repository.findById(id).map(existingEmployee -> {
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setDepartment(employeeDTO.getDepartment());
            existingEmployee.setSalary(employeeDTO.getSalary());
            return convertToDTO(repository.save(existingEmployee));
        }).orElse(null);
    }

    // Delete Employee
    public void deleteEmployeeDTO(Long id) {
        repository.deleteById(id);
    }*/

        private final EmployeeRepository employeeRepository;

        public EmployeeService(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        // Convert Employee to EmployeeDTO
        private EmployeeDTO convertToDTO(Employee employee) {
            return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary());
        }

        // Convert EmployeeDTO to Employee
        private Employee convertToEntity(EmployeeDTO employeeDTO) {
            return new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getSalary());
        }

        // Get All Employees as DTOs
        public List<EmployeeDTO> getAllEmployeesDTO() {
            return employeeRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        // Get Employee By ID as DTO
        public EmployeeDTO getEmployeeDTOById(Long id) {
            Optional<Employee> employee = employeeRepository.findById(id);
            return employee.map(this::convertToDTO).orElse(null);
        }

        // Add Employee using DTO
        public EmployeeDTO addEmployeeDTO(EmployeeDTO employeeDTO) {
            Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getSalary()); // ID auto-generated
            Employee savedEmployee = employeeRepository.save(employee);
            return convertToDTO(savedEmployee);
        }

        // Update Employee
        public EmployeeDTO updateEmployeeDTO(Long id, EmployeeDTO employeeDTO) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                Employee updatedEmployee = employeeRepository.save(employee);
                return convertToDTO(updatedEmployee);
            }
            return null; // Employee not found
        }

        // Delete Employee
        public void deleteEmployeeDTO(Long id) {
            employeeRepository.deleteById(id);
        }
    }



