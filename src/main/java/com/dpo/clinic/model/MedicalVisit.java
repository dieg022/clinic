package com.dpo.clinic.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class MedicalVisit implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	private Appoinment appoinment;
	@OneToOne
	private Doctor doctor;
	@OneToOne
	private Room room;
	
	public MedicalVisit() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MedicalVisit(Integer id, Appoinment appoinment, Doctor doctor, Room room) {
		super();
		this.id = id;
		this.appoinment = appoinment;
		this.doctor = doctor;
		this.room = room;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Appoinment getAppoinment() {
		return appoinment;
	}

	public void setAppoinment(Appoinment appoinment) {
		this.appoinment = appoinment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
