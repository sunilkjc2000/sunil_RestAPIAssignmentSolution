package com.greatlearning.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getEmployee")
	public Optional<Employee> getEmployee(int id) {
		return employeeService.getAEmployeeById(id);
	}

	@GetMapping("/listEmployees")
	public List<Employee> viewEmployees() {
		return employeeService.viewEmployees();
	}

	@PostMapping("/deleteEmployee")
	public String deleteEmployee(Integer id) {
		return employeeService.deleteEmployeeById(id);
	}

	@PostMapping("/addEmployee")
	public String addSingleEmployee(Employee employee) {
		return employeeService.addSingleEmployee(employee);
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@GetMapping("/searchByFirstname")
	public List<Employee> searchByFirstname(String firstName) {
		return employeeService.getEmployeeByName(firstName);
	}

	@GetMapping("/sortByFirstName")
	public List<Employee> getEmployeesInOrder(Direction direction)
	{
		return employeeService.getEmployeesInOrder(direction);
	}


}
