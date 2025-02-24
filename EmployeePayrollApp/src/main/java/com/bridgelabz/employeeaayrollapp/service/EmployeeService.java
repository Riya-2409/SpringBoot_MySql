package com.bridgelabz.employeeaayrollapp.service;

import com.bridgelabz.employeeaayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeeaayrollapp.model.Employee;
import com.bridgelabz.employeeaayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        private final List<Employee> employeeList = new ArrayList<>();
        private final AtomicLong counter = new AtomicLong(1); // To generate unique IDs manually

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
            return employeeList.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        // Get Employee By ID as DTO
        public EmployeeDTO getEmployeeDTOById(Long id) {
            return employeeList.stream()
                    .filter(emp -> emp.getId().equals(id))
                    .findFirst()
                    .map(this::convertToDTO)
                    .orElse(null);
        }

        // Add Employee using DTO
        public EmployeeDTO addEmployeeDTO(EmployeeDTO employeeDTO) {
            Employee employee = convertToEntity(employeeDTO);
            employee.setId(counter.getAndIncrement()); // Assign unique ID manually
            employeeList.add(employee);
            return convertToDTO(employee);
        }

        // Update Employee
        public EmployeeDTO updateEmployeeDTO(Long id, EmployeeDTO employeeDTO) {
            for (Employee employee : employeeList) {
                if (employee.getId().equals(id)) {
                    employee.setName(employeeDTO.getName());
                    employee.setDepartment(employeeDTO.getDepartment());
                    employee.setSalary(employeeDTO.getSalary());
                    return convertToDTO(employee);
                }
            }
            return null;
        }

        // Delete Employee
        public void deleteEmployeeDTO(Long id) {
            employeeList.removeIf(emp -> emp.getId().equals(id));
        }
    }


