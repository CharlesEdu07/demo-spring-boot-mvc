package com.charlesedu.course.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.charlesedu.course.boot.dao.AbstractDao;
import com.charlesedu.course.boot.dao.EmployeeDao;
import com.charlesedu.course.boot.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {

}
