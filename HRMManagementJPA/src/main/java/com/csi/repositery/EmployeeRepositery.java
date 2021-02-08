package com.csi.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csi.model.Employee;

public interface EmployeeRepositery extends JpaRepository<Employee, Integer>{

	
}
