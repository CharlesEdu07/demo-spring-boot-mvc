package com.charlesedu.course.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charlesedu.course.boot.dao.RoleDao;
import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.service.RoleService;
import com.charlesedu.course.boot.util.PaginationUtil;

@Service
@Transactional(readOnly = false)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao dao;

	@Override
	public void save(Role role) {
		dao.save(role);
	}

	@Override
	public void update(Role role) {
		dao.update(role);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Role findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean roleHaveEmployees(Long id) {
		if (findById(id).getEmployees().isEmpty()) {
			return false;
		}

		return true;
	}

	public PaginationUtil<Role> paginationSearch(int page, String sort, String property, int size) {
		return dao.paginationSearch(page, sort, property, size);
	}
}
