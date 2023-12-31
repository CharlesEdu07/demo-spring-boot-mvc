package com.charlesedu.course.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_EMPLOYEES")
public class Employee extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false, unique = true)
	private String name;

	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salary;

	@NotNull
	@PastOrPresent(message = "{PastOrPresent.employee.admissionDate}")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "admission_date", nullable = false, columnDefinition = "DATE")
	private LocalDate admissionDate;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "exit_date", columnDefinition = "DATE")
	private LocalDate exitDate;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id_fk")
	private Address address;

	@NotNull(message = "{NotNull.employee.role}")
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

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
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
