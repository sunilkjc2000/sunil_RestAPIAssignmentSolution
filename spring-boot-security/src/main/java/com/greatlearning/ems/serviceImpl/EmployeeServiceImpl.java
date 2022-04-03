package com.greatlearning.ems.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;
import com.greatlearning.ems.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> viewEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public List<Employee> getEmployeesInOrder(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}


	@Override
	public Optional<Employee> getAEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}


	@Override
	public String deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
		return "Employee with id: "+id+" is deleted";
	}


	public String addSingleEmployee(Employee employee) {
		employeeRepository.save(employee);
		employeeRepository.flush();
		return "Employee saved";
	}

	public Employee updateEmployee(Employee employee)
	{
		Employee emp = employeeRepository.findById(employee.getId()).get();
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		return employeeRepository.save(emp);

	}

	public List<Employee> getEmployeeByName(String firstName)
	{
		Employee employeeWithFirstName = new Employee();
		employeeWithFirstName.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "email","lastName");
		Example<Employee> example = Example.of(employeeWithFirstName, exampleMatcher);
		return employeeRepository.findAll(example, Sort.by("firstName"));


	}

}
