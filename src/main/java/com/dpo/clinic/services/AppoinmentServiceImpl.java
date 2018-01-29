package com.dpo.clinic.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpo.clinic.dao.AppoinmentDao;
import com.dpo.clinic.dto.AppoinmentDTO;
import com.dpo.clinic.model.Appoinment;

@Service
public class AppoinmentServiceImpl implements AppoinmentService {

	@Autowired
	private AppoinmentDao appoinmentDao;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public AppoinmentDTO transform(Appoinment appoinment) {
		return dozer.map(appoinment, AppoinmentDTO.class);
	}

	@Override
	public Appoinment transform(AppoinmentDTO appoinment) {
		return dozer.map(appoinment, Appoinment.class);
	}

	@Override
	public List<AppoinmentDTO> findAll() {
		final Iterable<Appoinment> findAll = appoinmentDao.findAll();
		final List<AppoinmentDTO> res = new ArrayList<>();
		findAll.forEach(ap-> {
			final AppoinmentDTO apDTO = transform(ap);
			res.add(apDTO);
		});
		return res;
	}

	@Override
	public AppoinmentDTO findById(Integer id) {
		final Appoinment ap=appoinmentDao.findOne(id);
		return transform(ap); 
	
	}

	@Override
	public AppoinmentDTO create(AppoinmentDTO appoinment) {
		
		final Appoinment apDTO=transform(appoinment);
		return transform(appoinmentDao.save(apDTO));
		
	}

	@Override
	public void update(AppoinmentDTO appoinment) {
		final Appoinment r = transform(appoinment);
		appoinmentDao.save(r);
		
	}

	@Override
	public void delete(Integer id) {
		appoinmentDao.delete(id);
		
	}
	
	
}
