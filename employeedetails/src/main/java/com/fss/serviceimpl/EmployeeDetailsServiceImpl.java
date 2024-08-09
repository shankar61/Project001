package com.fss.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.model.EmployeeDetails;
import com.fss.repository.EmployeeDetailsRepository;
import com.fss.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employeeDetails) {
		return employeeDetailsRepository.save(employeeDetails);
	}

	@Override
	public void deleteEmployee(Integer empId) {
		employeeDetailsRepository.deleteById(empId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeDetailsRepository.findAll();
	}

	@Override
	public Optional<EmployeeDetails> getEmployeeByEmpId(Integer empId) {
		return employeeDetailsRepository.findById(empId);

	}

}
