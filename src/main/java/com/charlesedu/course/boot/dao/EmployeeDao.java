package com.charlesedu.course.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.charlesedu.course.boot.domain.Employee;

public interface EmployeeDao {
	void save(Employee employee);

	Employee findById(Long id);

	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByRole(Long id);

	List<Employee> findByAdmissionDateAndExitDate(LocalDate admission, LocalDate exit);

    List<Employee> findByAdmissionDate(LocalDate admission);

    List<Employee> findByExitDate(LocalDate exit);

	void update(Employee employee);

	void delete(Long id);
}
