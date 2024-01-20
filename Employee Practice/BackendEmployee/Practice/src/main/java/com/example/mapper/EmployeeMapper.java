package com.example.mapper;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee; 

public class EmployeeMapper {
	
	public static EmployeeDto mapTOEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
		);
	}
	
	public static Employee mapTOEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
		);
	}
}
