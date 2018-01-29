package com.dpo.clinic.services;

import java.text.ParseException;
import java.util.List;

import com.dpo.clinic.dto.*;
import com.dpo.clinic.model.Doctor;

public interface DoctorService 
{
	 
	 DoctorDTO transform(Doctor doctor);
	 
	 Doctor transform(DoctorDTO doctorDTO);
	 
	 List<DoctorDTO> findAll();
	 
	 DoctorDTO findById(Integer id);
	 
	 DoctorDTO create(DoctorDTO doctor);
	 
	 void update(DoctorDTO doctor);
	 
	 void delete(Integer id);
	 
	 Integer getVisitForDoctorId(DoctorDTO doctor);
	 
	 Float getSalaryDoctor(DoctorDTO doctor);
	 
	 Float getSalaryDoctorDate(DoctorDTO doctor,String dateInit, String dateEnd) throws ParseException;
	 
	 Integer[] getTopDoctors(Integer limit);


}
