package com.dpo.clinic.dto;

import com.dpo.clinic.model.Appoinment;
import com.dpo.clinic.model.Doctor;
import com.dpo.clinic.model.Room;

public class MedicalVisitDTO {


	private Integer id;

	private Appoinment appoinment;
	
	private Doctor doctor;
	
	private Room room;

	public MedicalVisitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalVisitDTO(Integer id, Appoinment appoinment, Doctor doctor, Room room) {
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
