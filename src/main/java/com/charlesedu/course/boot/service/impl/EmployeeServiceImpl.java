package com.charlesedu.course.boot.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charlesedu.course.boot.dao.EmployeeDao;
import com.charlesedu.course.boot.domain.Employee;
import com.charlesedu.course.boot.service.EmployeeService;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Transactional(readOnly = false)
	@Override
	public void save(Employee employee) {
		dao.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Employee> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Employee> findByRole(Long id) {
		return dao.findByRole(id);
	}

	@Override
	public List<Employee> findByDate(LocalDate admission, LocalDate exit) {
		if (admission != null && exit != null) {
			return dao.findByAdmissionDateAndExitDate(admission, exit);
		} else if (admission != null) {
			return dao.findByAdmissionDate(admission);
		} else if (exit != null) {
			return dao.findByExitDate(exit);
		} else {
			return new ArrayList<>();
		}
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Employee employee) {
		dao.update(employee);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

}
