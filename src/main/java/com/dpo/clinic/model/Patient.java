package com.dpo.clinic.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity

public class Patient implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique=true)
	private String name;
	@Column(unique=true)
	private String dni;
	private String telephone;
	


	public Patient(Integer id, String name, String dni, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.telephone = telephone;

	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
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
