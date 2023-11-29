package com.prakash.service;

import java.util.List;

import com.prakash.entity.Employee;

public interface EmployeeService {
	public Employee saveEmp(Employee emp);

	public List<Employee> getAllEmp();

	public Employee getEmpById(Integer id);


	boolean deleteEmp(Integer id);
}
