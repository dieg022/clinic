package com.dpo.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpo.clinic.dto.MedicalVisitDTO;
import com.dpo.clinic.services.MedicalVisitServiceImpl;

@RestController
@RequestMapping(value="/visit")
public class MedicalVisitController 
{
	@Autowired
	MedicalVisitServiceImpl visitService;
	
	
	@RequestMapping(method = { RequestMethod.GET })
	public List<MedicalVisitDTO> getAll() 
	{
		return visitService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MedicalVisitDTO findOne(@PathVariable("id") Integer id) {
		return visitService.findById(id);
	}
	
	@RequestMapping(method = { RequestMethod.POST })
	public MedicalVisitDTO create(@RequestBody MedicalVisitDTO medicalVisit) {
		
		return visitService.create(medicalVisit);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody MedicalVisitDTO medicalVisit) {
		
		visitService.update(medicalVisit);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) {
		visitService.delete(id);
	}
}
