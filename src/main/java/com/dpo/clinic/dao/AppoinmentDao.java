package com.dpo.clinic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dpo.clinic.model.Appoinment;

@Repository
public interface AppoinmentDao extends CrudRepository<Appoinment, Integer> {

}
