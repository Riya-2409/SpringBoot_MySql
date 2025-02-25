package com.bridgelabz.employeeaayrollapp.service;

import com.bridgelabz.employeeaayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeeaayrollapp.model.Employee;
import com.bridgelabz.employeeaayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeeaayrollapp.validation.EmployeeNotFoundException;
<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
=======
>>>>>>> UC3-LogginG_Levels_Logging_To_Console_Logging_Patterns
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
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

<<<<<<< HEAD

        /*private final EmployeeRepository employeeRepository;
=======
    @Autowired
    private EmployeeRepository repository;
>>>>>>> UC3-LogginG_Levels_Logging_To_Console_Logging_Patterns

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

<<<<<<< HEAD
        public List<EmployeeDTO> getAllEmployeesDTO() {
            log.info("Fetching all employees...");
            return employeeRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        public EmployeeDTO getEmployeeDTOById(Long id) {
            log.debug("Getting employee with ID: {}", id);
            Optional<Employee> employee = employeeRepository.findById(id);
            return employee.map(this::convertToDTO).orElse(null);
        }

        public EmployeeDTO addEmployeeDTO(EmployeeDTO employeeDTO) {
            log.info("Adding new employee: {}", employeeDTO.getName());
            Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getSalary());
            Employee savedEmployee = employeeRepository.save(employee);
            log.info("Employee added with ID: {}", savedEmployee.getId());
            return convertToDTO(savedEmployee);
        }

        public EmployeeDTO updateEmployeeDTO(Long id, EmployeeDTO employeeDTO) {
            log.warn("Updating employee with ID: {}", id);
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                Employee updatedEmployee = employeeRepository.save(employee);
                log.info("Updated employee: {}", updatedEmployee);
                return convertToDTO(updatedEmployee);
            }
            log.error("Employee not found with ID: {}", id);
            return null;
        }

        public void deleteEmployeeDTO(Long id) {
            log.info("Deleting employee with ID: {}", id);
            employeeRepository.deleteById(id);
        }

        private EmployeeDTO convertToDTO(Employee employee) {
            return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary());
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
=======
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
>>>>>>> UC3-LogginG_Levels_Logging_To_Console_Logging_Patterns
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





