package com.prakash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prakash.entity.Employee;
import com.prakash.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/")
	public String index(Model model) {
		List<Employee> allEmp = empService.getAllEmp();
		model.addAttribute("empList", allEmp);
		return "index.html";

	}

	@GetMapping("/loadEmpSave")
	public String loadEmpSave(Model model) {
		Employee emp=new Employee();
		model.addAttribute("emp", emp);
		return "emp_save";

	}

	@GetMapping("/editEmp")
	public String editEmp() {
		return "edit_emp";

	}

	@PostMapping("/saveEmp")
	public String saveEmp( @Valid @ModelAttribute Employee emp,BindingResult result, HttpSession session) {
		
		if(result.hasErrors()) {
			return "emp_save";
		}

		Employee saveEmp = empService.saveEmp(emp);
		
		if (saveEmp != null) {
			session.setAttribute("msg", "Registered Successfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/loadEmpSave";

	}
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		Employee emp = empService.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_emp";
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {

		Employee updateEmp = empService.saveEmp(emp);

		if (updateEmp != null) {
			session.setAttribute("msg", "Update sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/";
	}

	@GetMapping("/deleteEmp/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f = empService.deleteEmp(id);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}
		return "redirect:/";
	}

}
