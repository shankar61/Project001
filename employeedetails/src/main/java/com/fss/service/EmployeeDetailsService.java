package com.fss.service;

import java.util.List;
import java.util.Optional;

import com.fss.model.EmployeeDetails;

public interface EmployeeDetailsService {

	EmployeeDetails createEmployee(EmployeeDetails employeeDetails);

	void deleteEmployee(Integer empId);

	List<EmployeeDetails> getAllEmployees();

	Optional<EmployeeDetails> getEmployeeByEmpId(Integer empId);

}
