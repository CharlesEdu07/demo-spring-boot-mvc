package com.charlesedu.course.boot.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ROLES")
public class Role extends AbstractEntity<Long> {

	@NotBlank(message = "O nome do cargo é obrigatório")
	@Size(min = 3, max = 60, message = "O nome do cargo deve conter no máximo 60 caracteres.")
	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;

	@NotNull(message = "Selecione o departamento relativo ao cargo")
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
