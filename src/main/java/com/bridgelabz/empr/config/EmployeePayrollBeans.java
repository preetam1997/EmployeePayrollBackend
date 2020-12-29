package com.bridgelabz.empr.config;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeePayrollBeans {
	
	@Bean
	public ModelMapper getModelMApper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldMatchingEnabled(true);
		return mapper;
	}
}
