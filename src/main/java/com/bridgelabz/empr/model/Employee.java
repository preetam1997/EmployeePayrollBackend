package com.bridgelabz.empr.model;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.empr.dto.EmployeePayrollDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	public String profile;
	public String gender;
	public String department;
	private long salary;
	public String day;
	public String month;
	public String year;
	public String notes;
	
	public Employee() {}
	
	public Employee(EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.name = employeePayrollDTO.name;
		this.profile = employeePayrollDTO.profile;
		this.gender = employeePayrollDTO.gender;
		this.department = employeePayrollDTO.department;
		this.salary = employeePayrollDTO.salary;
		this.day = employeePayrollDTO.day;
		this.month = employeePayrollDTO.month;
		this.year = employeePayrollDTO.year;
		this.notes = employeePayrollDTO.notes;
	}
	
	
}



