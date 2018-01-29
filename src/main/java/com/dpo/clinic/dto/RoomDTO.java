package com.dpo.clinic.dto;


import com.dpo.clinic.model.Clinic;

public class RoomDTO {

	private Integer id;
	
	private Clinic clinic;
	
	private String name;

	public RoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDTO(Integer id, Clinic clinic,String name) {
		super();
		this.id = id;
		this.clinic = clinic;
		this.name=name;
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
