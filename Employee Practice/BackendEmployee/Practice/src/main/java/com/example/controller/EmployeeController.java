package com.example.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDto;
import com.example.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//Build CreateEmployee Rest Api
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		
	 	EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
			
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		
	}
	
	//Build GetEmployee Rest Api
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		
		EmployeeDto employeeDto  = employeeService.getEmployeeById(employeeId);

		return ResponseEntity.ok(employeeDto);
		
	}
	
	//Build GetAllEmployee Rest Api
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		
		return ResponseEntity.ok(employees);
		
	}
	
	
	//Build Updated Employee Rest Api
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, 
													  @RequestBody EmployeeDto updatedEmployee){
		
		EmployeeDto updaterEmployeer = employeeService.updateEmployee(employeeId, updatedEmployee);
		
		return ResponseEntity.ok(updaterEmployeer);
		
	}
	
	//Build Delete Employee Rest Api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		
		employeeService.deleteEmployee(employeeId);
		
		return ResponseEntity.ok("Employee Deleted Succesfully!!");
		
	}

}
