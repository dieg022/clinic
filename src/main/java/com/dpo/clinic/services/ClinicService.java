package com.dpo.clinic.services;

import java.util.List;

import com.dpo.clinic.dto.ClinicDTO;
import com.dpo.clinic.model.Clinic;

public interface ClinicService {
	
	ClinicDTO transform(Clinic clinic);
	
	Clinic transform(ClinicDTO clinic);
	
	List<ClinicDTO> findAll();
	
	ClinicDTO findById(Integer id);
	
	ClinicDTO create(ClinicDTO clinic);
	
	void update(ClinicDTO clinic);
	
	void delete(Integer id);
	

}
