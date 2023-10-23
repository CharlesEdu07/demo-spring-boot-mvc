package com.charlesedu.course.boot.service;

import java.util.List;

import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.util.PaginationUtil;

public interface RoleService {
	void save(Role role);

	void update(Role role);

	void delete(Long id);

	Role findById(Long id);

	List<Role> findAll();
	
	boolean roleHaveEmployees(Long id);

	PaginationUtil<Role> paginationSearch(int page);
}
