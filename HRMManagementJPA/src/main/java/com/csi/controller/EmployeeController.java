package com.csi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired EmployeeDaoImpl employeeDaoImpl;
	
	@GetMapping("/getdata")
	public ResponseEntity<List<Employee>> getData() {
		
		return ResponseEntity.ok(employeeDaoImpl.getAlldata());
	}
	@GetMapping("/getdatabyid/{empId}")
	public ResponseEntity<Optional<Employee>> getDataById(@PathVariable("empId") int empId) {
		
		return ResponseEntity.ok(employeeDaoImpl.getDataById(empId));
	}
	
	@PostMapping("/savedata")
	public ResponseEntity<String> saveData(@RequestBody Employee employee)
	{
		employeeDaoImpl.saveData(employee);
		
		return ResponseEntity.ok("Employee data saved successfully");
	}
	
	@PostMapping("/savealldata")
	public ResponseEntity<String> saveAllData(@RequestBody List<Employee> employees )
	{
		employeeDaoImpl.saveAllData(employees);
		
		return ResponseEntity.ok("All Employees data saved successfully");
	}
	
	@PutMapping("/updatedata/{empId}")
	public  ResponseEntity<String> updateData(@PathVariable("empId") int empId, @RequestBody Employee employee)
	{
		employeeDaoImpl.updateData(empId, employee);
		
		return  ResponseEntity.ok("Employee data updated successfully");
	}
	
	@DeleteMapping("/deletedata/{empId}")
	public  ResponseEntity<String> deleteData(@PathVariable("empId") int empId) 
	{ 
		employeeDaoImpl.deleteData(empId);
		return  ResponseEntity.ok("Employee data deleted successfully");
	}
	
	@DeleteMapping("deletealldata")
	public ResponseEntity<String> deleteAllData() {
		
		employeeDaoImpl.deleteAllData();
		return ResponseEntity.ok("All Employee data deleted successfully");
		
	}
}
