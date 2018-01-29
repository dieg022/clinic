package com.dpo.clinic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Clinic implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique=true)
	private String name;
	
	
	
	public Clinic() {
		super();
	}

	public Clinic(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	
	

	
}
