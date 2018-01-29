package com.dpo.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpo.clinic.dto.ClinicDTO;
import com.dpo.clinic.dto.RoomDTO;
import com.dpo.clinic.services.ClinicService;
import com.dpo.clinic.services.RoomService;

@RestController
@RequestMapping(value="/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<ClinicDTO> getAll() 
	{
		return clinicService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClinicDTO findOne(@PathVariable("id") Integer id) {
		return clinicService.findById(id);
	}
	
	//Mostrar salas de una clínica
	@RequestMapping(value = "/{id}/rooms", method = RequestMethod.GET)
	public List<RoomDTO> findRooms(@PathVariable("id") Integer id) {
		return roomService.findAllByClinic(id);
	}
	
	
	
	@RequestMapping(method = { RequestMethod.POST })
	public ClinicDTO create(@RequestBody ClinicDTO room) {
		
		return clinicService.create(room);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody ClinicDTO room) {
		
		clinicService.update(room);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) {
		clinicService.delete(id);
	}
}
