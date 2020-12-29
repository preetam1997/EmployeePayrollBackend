package com.bridgelabz.empr.services;

import java.util.List;
import java.util.Optional;
import com.bridgelabz.empr.dto.EmployeePayrollDTO;
import com.bridgelabz.empr.exceptions.EmployeeException;
import com.bridgelabz.empr.model.Employee;

public interface IEmployeePayrollService {

	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	Employee updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, long id) throws EmployeeException;

	void deleteEmployeePayrollData(long id) throws EmployeeException;

	List<Employee> getAllEmployee();

	Optional<Employee> getEmployeeById(long id);
}
