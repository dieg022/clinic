package com.dpo.clinic.services;

import java.util.List;

import com.dpo.clinic.dto.RoomDTO;
import com.dpo.clinic.model.Room;



public interface RoomService {

	RoomDTO transform(Room room);
	
	Room transform(RoomDTO room);
	
	List<RoomDTO> findAll();
	
	RoomDTO findById(Integer id);
	
	//Busca todas las salas de una clínica;
	List<RoomDTO> findAllByClinic(Integer idClinic);
	
	RoomDTO create(RoomDTO room);
	
	void update(RoomDTO room);
	
	void delete(Integer id);
}
