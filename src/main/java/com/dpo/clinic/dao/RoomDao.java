package com.dpo.clinic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dpo.clinic.model.Room;

@Repository
public interface RoomDao extends CrudRepository<Room, Integer> {

}
