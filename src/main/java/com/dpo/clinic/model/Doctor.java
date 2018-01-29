package com.dpo.clinic.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

@Entity
public class Doctor implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Length(max=55)
	private String name;
	
	
	private Float price;
	
	private String idApi;
	
	public Doctor() 
	{
		super();
		
	}

	public Doctor(Integer id, String name, Float price, String idApi) {
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
	public void setId(Integer id) {
		this.id = id;
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
