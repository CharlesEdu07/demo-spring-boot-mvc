package com.charlesedu.course.boot.domain;

import com.charlesedu.course.boot.domain.enums.FederativeUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ADDRESS")
public class Address extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 1, max = 255)
	@Column(nullable = false)
	private String street;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String neighborhood;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String city;

	@NotNull(message = "{NotNull.address.federativeUnit}")
	@Column(name = "federative_unit", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private FederativeUnit federativeUnit;

	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.address.zipCode}")
	@Column(nullable = false, length = 9)
	private String zipCode;

	@NotNull
	@Digits(integer = 5, fraction = 0)
	@Column(nullable = false, length = 5)
	private Integer number;

	@Size(max = 255)
	private String complement;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public FederativeUnit getFederativeUnit() {
		return federativeUnit;
	}

	public void setFederativeUnit(FederativeUnit federativeUnit) {
		this.federativeUnit = federativeUnit;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}
