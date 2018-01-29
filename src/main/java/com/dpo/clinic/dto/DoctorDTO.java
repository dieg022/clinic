package com.dpo.clinic.dto;

import java.io.Serializable;


public class DoctorDTO implements Serializable
{
	private Integer id;
	private String name;
	private Float price;
	private String idApi;
	
	public DoctorDTO() {};

	public DoctorDTO(Integer id, String name, Float price, String idApi) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.idApi = idApi;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer integer) {
		this.id = integer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getIdApi() {
		return idApi;
	}

	public void setIdApi(String idApi) {
		this.idApi = idApi;
	}



	

}
