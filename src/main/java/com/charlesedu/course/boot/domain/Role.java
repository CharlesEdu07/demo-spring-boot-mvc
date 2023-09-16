package com.charlesedu.course.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ROLES")
public class Role extends AbstractEntity<Long> {
	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_department_fk")
	private Department deparment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDeparment() {
		return deparment;
	}

	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}
}
