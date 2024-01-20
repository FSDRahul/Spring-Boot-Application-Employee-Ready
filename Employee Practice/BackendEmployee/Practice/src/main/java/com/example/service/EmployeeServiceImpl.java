package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.exception.ResoureNotFoundException;
import com.example.mapper.EmployeeMapper;
import com.example.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapTOEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		
		
		return EmployeeMapper.mapTOEmployeeDto(savedEmployee);
	}



	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee  = employeeRepository.findById(employeeId)
		.orElseThrow(()-> new ResoureNotFoundException("Employee not found with id" + employeeId));
		
		return EmployeeMapper.mapTOEmployeeDto(employee);
	}



	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map((employee) -> EmployeeMapper.mapTOEmployeeDto(employee))
				.collect(Collectors.toList());
	}



	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResoureNotFoundException("Employee Does Not Exists With this Id" + employeeId)
		);
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updaterEmployer = employeeRepository.save(employee);
		
		return EmployeeMapper.mapTOEmployeeDto(updaterEmployer);
	}



	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResoureNotFoundException("Employee Does Not Exists With this Id" + employeeId)
		);
		
		employeeRepository.deleteById(employeeId);
		
	}

}
