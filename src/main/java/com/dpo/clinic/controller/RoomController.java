package com.dpo.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpo.clinic.dto.RoomDTO;
import com.dpo.clinic.services.RoomServiceImpl;

@RestController
@RequestMapping(value="/room")
public class RoomController 
{
	@Autowired
	RoomServiceImpl roomService;
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<RoomDTO> getAll() 
	{
		return roomService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RoomDTO findOne(@PathVariable("id") Integer id) {
		return roomService.findById(id);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public RoomDTO create(@RequestBody RoomDTO room) {
		
		return roomService.create(room);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody RoomDTO room) {
		
		roomService.update(room);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) {
		roomService.delete(id);
	}
}
