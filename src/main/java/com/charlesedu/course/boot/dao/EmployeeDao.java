package com.charlesedu.course.boot.dao;

import java.util.List;

import com.charlesedu.course.boot.domain.Employee;

public interface EmployeeDao {
	void save(Employee employee);

	Employee findById(Long id);

	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByRole(Long id);

	void update(Employee employee);

	void delete(Long id);
}
