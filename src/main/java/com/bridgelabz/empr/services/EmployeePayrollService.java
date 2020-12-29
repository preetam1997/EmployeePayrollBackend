package com.bridgelabz.empr.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.empr.dto.EmployeePayrollDTO;
import com.bridgelabz.empr.exceptions.EmployeeException;
import com.bridgelabz.empr.exceptions.EmployeeException.ExceptionType;
import com.bridgelabz.empr.model.Employee;
import com.bridgelabz.empr.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
	private IEmployeePayrollRepository employeePayrollRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	private boolean isIdPresent(long id) {
		return employeePayrollRepo.existsById(id);	
	}
	
	@Override
	public Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		Employee employee = modelMapper.map(employeePayrollDTO, Employee.class);
		System.out.println(employeePayrollDTO.profile);
		return employeePayrollRepo.save(employee);
	}

	@Override
	public Employee updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO, long id) throws EmployeeException {
		if(!isIdPresent(id)) {
			throw new EmployeeException("Not Present", ExceptionType.EMPLOYEE_NOT_FOUND);
		}
		Employee empToUpdate = employeePayrollRepo.getOne(id);
		empToUpdate.setName(employeePayrollDTO.name);
		empToUpdate.setProfile(employeePayrollDTO.profile);
		empToUpdate.setGender(employeePayrollDTO.gender);
		empToUpdate.setDepartment(employeePayrollDTO.department);
		empToUpdate.setSalary(employeePayrollDTO.salary);
		empToUpdate.setDay(employeePayrollDTO.day);
		empToUpdate.setMonth(employeePayrollDTO.month);
		empToUpdate.setYear(employeePayrollDTO.year);
		empToUpdate.setNotes(employeePayrollDTO.notes);
		return employeePayrollRepo.save(empToUpdate);		
	}

	@Override
	public void deleteEmployeePayrollData(long id) throws EmployeeException {
		if(!isIdPresent(id)) {
			throw new EmployeeException("Not Present", ExceptionType.EMPLOYEE_NOT_FOUND);
		}
		employeePayrollRepo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeePayrollRepo.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeePayrollRepo.findById(id);
	}
	
}
