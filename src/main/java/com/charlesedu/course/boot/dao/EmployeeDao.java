package com.charlesedu.course.boot.dao;

import java.util.List;

import com.charlesedu.course.boot.domain.Employee;

public interface EmployeeDao {
	void save(Employee employee);

	void update(Employee employee);

	void delete(Long id);

	Employee findById(Long id);

	List<Employee> findAll();
}
