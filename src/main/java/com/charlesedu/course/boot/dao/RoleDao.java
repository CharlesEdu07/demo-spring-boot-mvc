package com.charlesedu.course.boot.dao;

import java.util.List;

import com.charlesedu.course.boot.domain.Role;

public interface RoleDao {
	void save(Role role);

	void update(Role role);

	void delete(Long id);

	Role findById(Long id);

	List<Role> findAll();
}
