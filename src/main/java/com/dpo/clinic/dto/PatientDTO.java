package com.dpo.clinic.dto;

import java.io.Serializable;

public class PatientDTO implements Serializable {

	private Integer id;
	private String name;
	private String dni;
	private String telephone;
	
	public PatientDTO() {};
	
	public PatientDTO(Integer id, String name, String dni, String telephone) 
	{
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.telephone = telephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
}
