package com.dpo.clinic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dpo.clinic.model.Patient;
@Repository
public interface PatientDao extends CrudRepository<Patient, Integer>{

}
