package com.charlesedu.course.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@SuppressWarnings("serial")
public class Address extends AbstractEntity<Long> {
	@Column(nullable = false)
	private String publicArea;

	@Column(nullable = false)
	private String neighborhood;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private FederativeUnit federativaUnit;

	@Column(nullable = false, length = 9)
	private String cep;

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

	public FederativeUnit getFederativaUnit() {
		return federativaUnit;
	}

	public void setFederativaUnit(FederativeUnit federativaUnit) {
		this.federativaUnit = federativaUnit;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
