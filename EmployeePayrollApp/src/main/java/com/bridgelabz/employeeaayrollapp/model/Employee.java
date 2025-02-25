package com.bridgelabz.employeeaayrollapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "employees")
@Data  // Generates Getters, Setters, toString(), equals(), and hashCode()
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs
    private Long id;

    private String name;
    private double salary;
}
