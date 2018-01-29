package com.dpo.clinic.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpo.clinic.dao.PatientDao;
import com.dpo.clinic.dto.PatientDTO;
import com.dpo.clinic.model.Patient;
@Service
public class PatientServiceImpl implements PatientService 
{

	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public PatientDTO transform(Patient patient) {
		return dozer.map(patient,PatientDTO.class);
	}

	@Override
	public Patient transform(PatientDTO patient) {
		return dozer.map(patient, Patient.class);
	}

	@Override
	public List<PatientDTO> findAll() {
		final Iterable<Patient> findAll = patientDao.findAll();
		final List<PatientDTO> res = new ArrayList<>();
		findAll.forEach(p -> {
			final PatientDTO pDTO = transform(p);
			res.add(pDTO);
		});
		return res;
	}

	@Override
	public PatientDTO findById(Integer id) {
		final Patient p=patientDao.findOne(id);
		return transform(p);
	}

	@Override
	public PatientDTO create(PatientDTO patient) {
		final Patient p=transform(patient);
		return transform(patientDao.save(p));
	}

	@Override
	public void update(PatientDTO patient) {
		final Patient p = transform(patient);
		patientDao.save(p);
		
	}

	@Override
	public void delete(Integer id) {
		patientDao.delete(id);
		
	}

}
