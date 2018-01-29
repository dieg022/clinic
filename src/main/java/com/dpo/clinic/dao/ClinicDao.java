package com.dpo.clinic.dao;

import org.springframework.data.repository.CrudRepository;

import com.dpo.clinic.model.Clinic;

public interface ClinicDao extends CrudRepository<Clinic, Integer> {

}
