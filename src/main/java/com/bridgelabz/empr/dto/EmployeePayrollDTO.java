package com.bridgelabz.empr.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeePayrollDTO {
	@Pattern(regexp = "^([A-Z]{1})([a-z]{2,})$", message = "name should start with Capital and have atleast 3 letters")
	@Size(max = 10, min = 3, message = "name should be between 3-10")
	public String name;
	public String profile;
	public String gender;
	public String department;
	@Min(value = 10,message = "salary should be of more than 1 digit")
	@Max(value = 999999999, message = "salary should not exceed 9 digits")
	public long salary;
	public String day;
	public String month;
	public String year;
	public String notes;
}
