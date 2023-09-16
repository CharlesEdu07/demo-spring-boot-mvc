package com.charlesedu.course.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_department")
public class Department extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
