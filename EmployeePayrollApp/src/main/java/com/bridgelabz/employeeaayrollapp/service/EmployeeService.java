package com.bridgelabz.employeeaayrollapp.service;

import com.bridgelabz.employeeaayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeeaayrollapp.model.Employee;
import com.bridgelabz.employeeaayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeeaayrollapp.validation.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return repository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        repository.deleteById(id);
    }
    }



