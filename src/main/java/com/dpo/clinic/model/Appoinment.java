package com.dpo.clinic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;


@Entity

public class Appoinment implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date hour;
	@OneToOne
	private Patient patient;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getHour() {
		return hour;
	}
	public void setHour(Date hour) {
		this.hour = hour;
	}

	
	
	
	
}
