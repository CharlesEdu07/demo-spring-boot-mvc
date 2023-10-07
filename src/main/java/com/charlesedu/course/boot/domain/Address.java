package com.charlesedu.course.boot.domain;

import com.charlesedu.course.boot.domain.enums.FederativeUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ADDRESS")
public class Address extends AbstractEntity<Long> {
	@Column(nullable = false)
	private String publicArea;

	@Column(nullable = false)
	private String neighborhood;

	@Column(nullable = false)
	private String city;

	@Column(name = "federative_unit", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private FederativeUnit federativeUnit;

	@Column(nullable = false, length = 9)
	private String zipCode;

	@Column(nullable = false, length = 5)
	private Integer number;

	private String complement;

	public String getPublicArea() {
		return publicArea;
	}

	public void setPublicArea(String publicArea) {
		this.publicArea = publicArea;
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
