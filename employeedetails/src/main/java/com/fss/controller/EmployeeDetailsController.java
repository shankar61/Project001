package com.fss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fss.model.EmployeeDetails;
import com.fss.service.EmployeeDetailsService;

@RestController
@RequestMapping("/employees")
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@PostMapping("/save")
	public ResponseEntity<EmployeeDetails> saveEmployee(@RequestBody EmployeeDetails employeeDetails) {
		EmployeeDetails newEmployee = employeeDetailsService.createEmployee(employeeDetails);
		return new ResponseEntity<EmployeeDetails>(newEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDetails>> getEmployees() {
		List<EmployeeDetails> employeeDetails = employeeDetailsService.getAllEmployees();
		return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable Integer empId) {
		Optional<EmployeeDetails> getByEmpId = employeeDetailsService.getEmployeeByEmpId(empId);
		 return new ResponseEntity<>(getByEmpId.get(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmp(@PathVariable Integer empId) {
		employeeDetailsService.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
