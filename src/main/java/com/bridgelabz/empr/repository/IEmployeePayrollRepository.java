package com.bridgelabz.empr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.empr.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Long>{
	
	
}
