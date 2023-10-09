package com.charlesedu.course.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.charlesedu.course.boot.domain.Employee;

public interface EmployeeService {
	void save(Employee employee);

	List<Employee> findAll();

	Employee findById(Long id);

	List<Employee> findByName(String name);

	List<Employee> findByRole(Long id);

	List<Employee> findByDate(LocalDate admission, LocalDate exit);

	void update(Employee employee);

	void delete(Long id);
}
