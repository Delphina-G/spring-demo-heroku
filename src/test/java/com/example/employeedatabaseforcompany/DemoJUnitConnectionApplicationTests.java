package com.example.employeedatabaseforcompany;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.employeedatabaseforcompany.models.EmployeeDetails;
import com.example.employeedatabaseforcompany.repository.EmployeeRepository;
import com.example.employeedatabaseforcompany.services.EmployeeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DemoJUnitConnectionApplicationTests {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private EmployeeService empService;
	
	@Test
	void contextLoads() {
	}
	@Test
	@Order(1)
	public void addEmpDetails() {
		EmployeeDetails emp=new EmployeeDetails();
		emp.setEmp_id(1);
		emp.setName("delphina");
		emp.setCity("chennai");
		//empRepo.save(emp);
		EmployeeDetails actualEmp=empService.addEmployee(emp);
		assertThat(emp.equals(actualEmp));
		
	}
	
	@Test
	@Order(2)
	public void fetchEmpDetails() {
		EmployeeDetails empExpect=empRepo.findById(1).get();
		EmployeeDetails emp=empService.fetchEmployee(1);
		assertThat(emp.equals(empExpect));
	}
	
	@Test
	@Order(3)
	public void updateEmpDetails() {
		EmployeeDetails emp=new EmployeeDetails();
		emp.setName("delphina");
		emp.setCity("kerala");
		EmployeeDetails updateEmp=empService.updateEmployee(emp, 1);
		assertThat(emp.equals(updateEmp));
	}
	
	@Test
	@Order(4)
	//@Rollback(false)
	public void deleteEmpDetails() {
		empService.deleteEmployee(1);
		Boolean isExist=empRepo.findById(1).isPresent();
		assertFalse(isExist);
	}
	
}
