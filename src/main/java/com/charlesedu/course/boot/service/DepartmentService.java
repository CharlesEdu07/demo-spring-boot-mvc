package com.charlesedu.course.boot.service;

import java.util.List;

import com.charlesedu.course.boot.domain.Department;

public interface DepartmentService {
	void save(Department department);

	void update(Department department);

	void delete(Long id);

	Department findById(Long id);

	List<Department> findAll();

	boolean departmentHaveRoles(Long id);
}
