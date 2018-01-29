package com.dpo.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpo.clinic.dto.AppoinmentDTO;
import com.dpo.clinic.services.AppoinmentServiceImpl;

@RestController
@RequestMapping(value="/appoinment")
public class AppoinmentController {

	@Autowired
	AppoinmentServiceImpl appoinmentService;
	
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<AppoinmentDTO> getAll() 
	{
		return appoinmentService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AppoinmentDTO findOne(@PathVariable("id") Integer id) {
		return appoinmentService.findById(id);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public AppoinmentDTO create(@RequestBody AppoinmentDTO appoinment) {
		
		return appoinmentService.create(appoinment);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody AppoinmentDTO appoinment) {
		
		appoinmentService.update(appoinment);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) {
		appoinmentService.delete(id);
	}
}
