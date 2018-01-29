package com.dpo.clinic.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dpo.clinic.dto.DoctorDTO;
import com.dpo.clinic.dto.MedicalVisitDTO;

import com.dpo.clinic.services.DoctorService;
import com.dpo.clinic.services.DoctorServiceImpl;
import com.dpo.clinic.services.MedicalVisitService;

@RestController
@RequestMapping(value="/doctor")
public class DoctorController {
	
	private static final Logger log = LoggerFactory.getLogger(DoctorController.class); 
	
	@Autowired
	 DoctorService doctorService;
	
	@Autowired 
	MedicalVisitService visitService;

	/*
	 * Nos muestra el salario de un doctor desde que está registrado en el sistema
	 */

	@RequestMapping(value="/{id}/salary",method = { RequestMethod.GET })
	public Float getSalaryDoctor(@PathVariable("id") Integer id) 
	{
		return doctorService.getSalaryDoctor(doctorService.findById(id));
	}
	
	/*
	 * Nos devuelve el salario de un doctor entre dos fechas dadas.
	 */
	@RequestMapping(value="/{id}/salaryDate",method = { RequestMethod.GET })
	public Float getSalaryDoctorDate(@PathVariable("id") Integer id,@RequestParam("dateInit")String dateInit,@RequestParam("dateEnd")String dateEnd) throws ParseException 
	{
		log.debug("Buscamos el salario de un medico por rango de fechas"+dateInit);
		return doctorService.getSalaryDoctorDate(doctorService.findById(id),dateInit,dateEnd);
	}
	
	/*
	 * Nos muestra el top de los doctores con más pacientes
	 */
	@RequestMapping(value="/doctor/stats",method= {RequestMethod.GET})
	public Integer[] getTopDoctors()
	{
		return doctorService.getTopDoctors(5);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<DoctorDTO> findAll()
	{
		return doctorService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DoctorDTO findOne(@PathVariable("id") Integer id) {
		return doctorService.findById(id);
	}

	@RequestMapping(method = { RequestMethod.POST })
	public DoctorDTO create(@RequestBody DoctorDTO doctor) {
		
		return doctorService.create(doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody DoctorDTO doctor) {
		
		doctorService.update(doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) {
		doctorService.delete(id);
	}
	
	@RequestMapping(value = "/{id}/visits", method = { RequestMethod.GET})
	public List<MedicalVisitDTO> getVisitsDoctor(@PathVariable("id") Integer id) {
		return visitService.findVisitForIdDoctor(id);
	}
	
	@RequestMapping(value = "/{id}/visits/{idVisit}", method = { RequestMethod.GET})
	public MedicalVisitDTO getVisitsDoctor(@PathVariable("id") Integer id,@PathVariable("idVisit") Integer idVisit) {
		return visitService.findById(idVisit);
	}
}
