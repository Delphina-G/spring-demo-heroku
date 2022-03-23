package com.example.employeedatabaseforcompany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeedatabaseforcompany.models.EmployeeDetails;
import com.example.employeedatabaseforcompany.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository empRepo;
	
	public EmployeeDetails addEmployee(EmployeeDetails employee) {
		return empRepo.save(employee);
	}
	
	public EmployeeDetails fetchEmployee(Integer id) {
		return empRepo.findById(id).orElse(null);
	}
	
	public EmployeeDetails updateEmployee(EmployeeDetails employee,Integer id) {
		EmployeeDetails emp=empRepo.findById(id).orElse(null);
		emp.setName(employee.getName());
		emp.setCity(employee.getCity());
		
		return empRepo.save(emp);
	}
	
	public void deleteEmployee(Integer id) {
		empRepo.deleteById(id);
		
	}
	
}
