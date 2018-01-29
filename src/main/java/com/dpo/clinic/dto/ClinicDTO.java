package com.dpo.clinic.dto;

import java.io.Serializable;


public class ClinicDTO implements Serializable {

	private Integer id;
	private String name;
	public ClinicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClinicDTO(Integer id, String name) {
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
