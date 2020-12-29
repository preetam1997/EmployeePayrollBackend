package com.bridgelabz.empr.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.empr.dto.EmployeePayrollDTO;
import com.bridgelabz.empr.exceptions.EmployeeException;
import com.bridgelabz.empr.model.Employee;
import com.bridgelabz.empr.services.IEmployeePayrollService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	
	@ApiOperation(value = "This Is Used For Demo Purpose")
	@GetMapping(value = {""})
	public ResponseEntity<String> getEmployeePayrollData() {
		return new ResponseEntity<String>("Employee Data",HttpStatus.OK);
	}
	
	
	/**
	 * This Is Used To Add One Employee at a time
	 * @param employeePayrollDTO
	 * @return
	 */
	@ApiOperation(value = "This Is Used To Add One Employee at a time", notes = "Enter name in string and salary in long format", response = String.class)
	@PostMapping(value = "/add")
	public ResponseEntity<String> addEmployee(@RequestBody @Valid EmployeePayrollDTO employeePayrollDTO){
		employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		return new ResponseEntity<String>("Added",HttpStatus.CREATED);
	}
	
	/**
	 * This Is Used To Get All Employees
	 * @param employeePayrollDTO
	 * @return
	 */
	@ApiOperation(value = "This Is Used To Get All Employees", response = String.class)
	@GetMapping(value = {"/","/get"})
	public ResponseEntity<List<Employee>> getEmployee() {
		return new ResponseEntity<List<Employee>>(employeePayrollService.getAllEmployee(),HttpStatus.OK);
	}
	
	/**
	 * This Is Used To Get Employee by Id
	 * @param employeePayrollDTO
	 * @return
	 */
	@ApiOperation(value = "This Is Used To Get Employee by Id", response = String.class)
	@GetMapping(value = "/getById/{empId}")
	public ResponseEntity<Optional<Employee>> getEmployeeByTheirId(@PathVariable long empId) {
		return new ResponseEntity<Optional<Employee>>(employeePayrollService.getEmployeeById(empId),HttpStatus.OK);
	}
	
	/**
	 * This Is Used To Update Employee
	 * @param employeePayrollDTO
	 * @return
	 */
	@ApiOperation(value = "This Is Used To Update Employee", response = String.class)
	@PutMapping(value = "/update/{empId}")
	public ResponseEntity<String> Update(@RequestBody @Valid EmployeePayrollDTO employeePayrollDTO, @PathVariable int empId) throws EmployeeException {
		employeePayrollService.updateEmployeePayrollData(employeePayrollDTO, empId);
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
		
	}
	
	/**
	 * This Is Used To Update Employee
	 * @param employeePayrollDTO
	 * @return
	 */
	@ApiOperation(value = "This Is Used To delete Employee", response = String.class)
	@DeleteMapping(value = "/delete/{empId}")
	public ResponseEntity<String> Delete(@PathVariable int empId) throws EmployeeException {
		employeePayrollService.deleteEmployeePayrollData(empId);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
