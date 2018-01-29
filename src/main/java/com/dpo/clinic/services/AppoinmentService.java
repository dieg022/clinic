package com.dpo.clinic.services;

import java.util.List;

import com.dpo.clinic.dto.AppoinmentDTO;
import com.dpo.clinic.model.Appoinment;


public interface AppoinmentService {
	
	AppoinmentDTO transform(Appoinment appoinment);
	
	Appoinment transform(AppoinmentDTO appoinment);
	
	List<AppoinmentDTO> findAll();
	
	AppoinmentDTO findById(Integer id);
	
	AppoinmentDTO create(AppoinmentDTO appoinment);
	
	void update(AppoinmentDTO appoinment);
	
	void delete(Integer id);
	

}
