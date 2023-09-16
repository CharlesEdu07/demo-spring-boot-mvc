package com.charlesedu.course.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_EMPLOYEES")
public class Employee extends AbstractEntity<Long> {
	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salary;

	@Column(name = "entry_date", nullable = false, columnDefinition = "DATE")
	private LocalDate entryDate;

	@Column(name = "exit_date", columnDefinition = "DATE")
	private LocalDate exitDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id_fk")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "role_id_fk")
	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDate getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
