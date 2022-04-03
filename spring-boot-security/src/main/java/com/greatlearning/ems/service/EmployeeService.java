package com.greatlearning.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.ems.entity.Employee;

public interface EmployeeService {


	List<Employee> viewEmployees();

	List<Employee> getEmployeesInOrder(Direction direction);

	Optional<Employee> getAEmployeeById(Integer id);

	List<Employee> getEmployeeByName(String firstName);

	Employee updateEmployee(Employee employee);

	String deleteEmployeeById(Integer id);

	String addSingleEmployee(Employee employee);

}