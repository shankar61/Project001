package com.fss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fss.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer>{

}
