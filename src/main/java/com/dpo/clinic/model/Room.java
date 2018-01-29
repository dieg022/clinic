package com.dpo.clinic.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Room implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Clinic clinic;
	
	private String name;
	
	

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(Integer id, Clinic clinic, String name) {
		super();
		this.id = id;
		this.clinic = clinic;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
