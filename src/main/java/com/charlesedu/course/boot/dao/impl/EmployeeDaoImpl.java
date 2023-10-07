package com.charlesedu.course.boot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.charlesedu.course.boot.dao.AbstractDao;
import com.charlesedu.course.boot.dao.EmployeeDao;
import com.charlesedu.course.boot.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {
    public List<Employee> findByName(String name) {
        return createQuery("select e from Employee e where e.name like concat('%', ?1, '%')", name);
    }
}
