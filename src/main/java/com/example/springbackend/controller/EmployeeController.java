package com.example.springbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.springbackend.Exception.ResouraceNotFoundException;
import com.example.springbackend.entity.Employee;
import com.example.springbackend.repository.EmployeeRespository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRespository employeeRespository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeRespository.findAll();
	}

	@PostMapping("/employees")
	public Employee createEmploye(@RequestBody Employee emp) {
		return employeeRespository.save(emp);

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id) {
		Employee emp = employeeRespository.findById(id)
				.orElseThrow(() -> new ResouraceNotFoundException("Employee not exist with id:" + id));
		return ResponseEntity.ok(emp);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee empdtls) {
		Employee employe = employeeRespository.findById(id)
				.orElseThrow(() -> new ResouraceNotFoundException("Employee id not exist" + id));
		employe.setFirstName(empdtls.getFirstName());
		employe.setLastName(empdtls.getLastName());
		employe.setEmail(empdtls.getEmail());
		Employee updateemployee = employeeRespository.save(employe);
		return ResponseEntity.ok(updateemployee);

	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
		Employee emp=employeeRespository.findById(id)
				.orElseThrow(()-> new ResouraceNotFoundException("Employee id not exist"+id));
		employeeRespository.delete(emp);
		Map<String, Boolean> res=new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}

}
