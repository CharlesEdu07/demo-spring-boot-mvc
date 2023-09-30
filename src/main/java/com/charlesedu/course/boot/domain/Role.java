package com.charlesedu.course.boot.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ROLES")
public class Role extends AbstractEntity<Long> {
	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_department_fk")
	private Department department;

	@OneToMany(mappedBy = "role")
	private List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
