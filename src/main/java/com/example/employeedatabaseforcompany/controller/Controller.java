package com.example.employeedatabaseforcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedatabaseforcompany.models.EmployeeDetails;
import com.example.employeedatabaseforcompany.services.EmployeeService;

@RestController
public class Controller {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmployee")
	public EmployeeDetails addEmployee(@RequestBody EmployeeDetails employee) {
		return empService.addEmployee(employee);
	}
	
	@GetMapping("/fetchEmployee/{id}")
	public EmployeeDetails fetchEmployee(@PathVariable Integer id) {
		return empService.fetchEmployee(id);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public EmployeeDetails updateEmployee(@RequestBody EmployeeDetails employee,@PathVariable Integer id) {
		return empService.updateEmployee(employee, id);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		empService.deleteEmployee(id);
	}
}
