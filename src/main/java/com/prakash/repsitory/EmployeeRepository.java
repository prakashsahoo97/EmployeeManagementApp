package com.prakash.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prakash.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
