package com.prakash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.prakash.entity.Employee;
import com.prakash.repsitory.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmpServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmp(Employee emp) {
		Employee newEmp = employeeRepository.save(emp);
		return newEmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> findAllEmp = employeeRepository.findAll();
		return findAllEmp;
	}

	@Override
	public Employee getEmpById(Integer id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmp(Integer id) {
		Employee employee = employeeRepository.findById(id).get();
		if (employee != null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");

	}

}
