package com.charlesedu.course.boot.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DEPARTMENTS")
public class Department extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;
	
	@OneToMany(mappedBy = "department")
	private List<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}
}
