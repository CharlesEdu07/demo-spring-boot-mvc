package com.charlesedu.course.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.charlesedu.course.boot.dao.AbstractDao;
import com.charlesedu.course.boot.dao.DepartmentDao;
import com.charlesedu.course.boot.domain.Department;

@Repository
public class DepartmentDaoImpl extends AbstractDao<Department, Long> implements DepartmentDao {
	
}
