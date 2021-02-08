package com.csi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.csi.model.Employee;
import com.csi.repositery.EmployeeRepositery;

@Controller
public class EmployeeDaoImpl {
	
	@Autowired EmployeeRepositery employeeRepository;
	
	public List<Employee> getAlldata() {
		
		return employeeRepository.findAll();
	}  
	
	public Optional<Employee> getDataById(int empId) {
		
		
		return employeeRepository.findById(empId);
		
	}
	
	public void saveData(Employee employee) {
		
		employeeRepository.save(employee);
	}
	
	public void saveAllData(List<Employee> employees) {
		
		employeeRepository.saveAll(employees);
		
		
	}
	
	public void updateData(int empId, Employee employee) {
		Employee emp = employeeRepository.getOne(empId);
		emp.setEmpFirstName(employee.getEmpFirstName());
		emp.setEmpLastName(employee.getEmpLastName());
		emp.setEmpEmail(employee.getEmpEmail());
		employeeRepository.save(emp);
		
	}
	
	public void deleteData(int empId) {
		employeeRepository.deleteById(empId);
		
	}
	
	public void deleteAllData() {
		
		employeeRepository.deleteAll();
	}
}
