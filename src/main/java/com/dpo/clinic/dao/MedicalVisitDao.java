package com.dpo.clinic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dpo.clinic.model.MedicalVisit;

@Repository
public interface MedicalVisitDao extends CrudRepository<MedicalVisit, Integer>{
	


}
