package com.dpo.clinic.services;

import java.util.List;

import com.dpo.clinic.dto.PatientDTO;
import com.dpo.clinic.model.Patient;

public interface PatientService {
	
	 PatientDTO transform(Patient patient);
	 
	 Patient transform(PatientDTO patient);
	 
	 List<PatientDTO> findAll();
	 
	 PatientDTO findById(Integer id);
	 
	 PatientDTO create(PatientDTO patient);
	 
	 void update(PatientDTO patient);
	 
	 void delete(Integer id);
}
