package com.charlesedu.course.boot.dao.impl;

import java.time.LocalDate;
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

    public List<Employee> findByRole(Long id) {
        return createQuery("select e from Employee e where e.role.id = ?1", id);
    }

    public List<Employee> findByAdmissionDateAndExitDate(LocalDate admission, LocalDate exit) {
        String jpql = new StringBuilder("select e from Employee e ")
                .append("where e.admissionDate >= ?1 and e.exitDate <= ?2 ").append("order by e.admissionDate asc")
                .toString();

        return createQuery(jpql, admission, exit);
    }

    public List<Employee> findByAdmissionDate(LocalDate admission) {
        String jpql = new StringBuilder("select e from Employee e ")
                .append("where e.admissionDate = ?1 ").append("order by e.admissionDate asc")
                .toString();

        return createQuery(jpql, admission);
    }

    public List<Employee> findByExitDate(LocalDate exit) {
        String jpql = new StringBuilder("select e from Employee e ")
                .append("where e.exitDate = ?1 ").append("order by e.admissionDate asc")
                .toString();

        return createQuery(jpql, exit);
    }
}
