package com.dpo.clinic.services;

import java.util.List;

import com.dpo.clinic.dto.MedicalVisitDTO;
import com.dpo.clinic.model.MedicalVisit;



public interface MedicalVisitService {

	MedicalVisitDTO transform(MedicalVisit medicalVisti);
	
	MedicalVisit transform(MedicalVisitDTO medicalVisit);
	
	List<MedicalVisitDTO> findAll();
	
	MedicalVisitDTO findById(Integer id);
	
	MedicalVisitDTO create(MedicalVisitDTO medicalVisit);
	
	void update(MedicalVisitDTO medicalVisit);
	
	void delete(Integer id);
	
	/*
	 * Precondición: Id del doctor por el cual vamos a filtrar las consultas
	 * Nos devolverá una lista de las consultas de ese Doctor
	 */
	List<MedicalVisitDTO> findVisitForIdDoctor(Integer idDoctor);
}
