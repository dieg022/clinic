package com.dpo.clinic.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpo.clinic.dao.ClinicDao;
import com.dpo.clinic.dto.ClinicDTO;
import com.dpo.clinic.model.Clinic;
@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	private ClinicDao clinicDao;
	
	@Autowired
	private DozerBeanMapper dozer;
	@Override
	public ClinicDTO transform(Clinic clinic) {
	
		return dozer.map(clinic, ClinicDTO.class);
	}

	@Override
	public Clinic transform(ClinicDTO clinic) {

		return dozer.map(clinic, Clinic.class);
	}

	@Override
	public List<ClinicDTO> findAll() {
		final Iterable<Clinic> findAll = clinicDao.findAll();
		final List<ClinicDTO> res = new ArrayList<>();
		findAll.forEach(d -> {
			final ClinicDTO dDTO = transform(d);
			res.add(dDTO);
		});
		return res;
	}

	@Override
	public ClinicDTO findById(Integer id) {
		final Clinic c=clinicDao.findOne(id);
		return transform(c);
	}

	@Override
	public ClinicDTO create(ClinicDTO clinic) {
		final Clinic c=transform(clinic);
		return transform(clinicDao.save(c));
	}

	@Override
	public void update(ClinicDTO clinic) {
		final Clinic c= transform(clinic);
		clinicDao.save(c);
		
	}

	@Override
	public void delete(Integer id) {
		clinicDao.delete(id);
	}

}
