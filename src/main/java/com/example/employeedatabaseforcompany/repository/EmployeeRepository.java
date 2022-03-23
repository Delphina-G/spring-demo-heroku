package com.example.employeedatabaseforcompany.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.employeedatabaseforcompany.models.EmployeeDetails;

public interface EmployeeRepository extends CrudRepository<EmployeeDetails,Integer>{

}
