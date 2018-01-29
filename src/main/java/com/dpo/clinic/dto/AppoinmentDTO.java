package com.dpo.clinic.dto;

import com.dpo.clinic.enums.Turno;

public class AppoinmentDTO {


	private Integer id;

	private String date;

	private String hour;

	private Turno tourn;

	
	public AppoinmentDTO() {
		super();
	}


	public AppoinmentDTO(Integer id, String date, String hour, Turno tourn) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.tourn = tourn;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getHour() {
		return hour;
	}


	public void setHour(String hour) {
		this.hour = hour;
	}


	public Turno getTourn() {
		return tourn;
	}


	public void setTourn(Turno tourn) {
		this.tourn = tourn;
	}
	
	
	
}
