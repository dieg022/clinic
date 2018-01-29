package com.dpo.clinic.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpo.clinic.dao.MedicalVisitDao;
import com.dpo.clinic.dto.MedicalVisitDTO;
import com.dpo.clinic.model.MedicalVisit;
@Service
public class MedicalVisitServiceImpl implements MedicalVisitService {

	@Autowired
	private MedicalVisitDao medicalDao;
	@Autowired
	private DozerBeanMapper dozer;
	@Override
	public MedicalVisitDTO transform(MedicalVisit medicalVisti) {
		return dozer.map(medicalVisti, MedicalVisitDTO.class);
	}

	@Override
	public MedicalVisit transform(MedicalVisitDTO medicalVisit) {
		return dozer.map(medicalVisit,MedicalVisit.class);
	}

	@Override
	public List<MedicalVisitDTO> findAll() {
		final Iterable<MedicalVisit> findAll = medicalDao.findAll();
		final List<MedicalVisitDTO> res = new ArrayList<>();
		findAll.forEach(mv-> {
			final MedicalVisitDTO mvDTO = transform(mv);
			res.add(mvDTO);
		});
		return res;
	}

	@Override
	public MedicalVisitDTO findById(Integer id) {
		final MedicalVisit mv=medicalDao.findOne(id);
		return transform(mv);
	}

	@Override
	public MedicalVisitDTO create(MedicalVisitDTO medicalVisit) {
		final MedicalVisit mvDto=transform(medicalVisit);
		return transform(medicalDao.save(mvDto));
		
	}

	@Override
	public void update(MedicalVisitDTO medicalVisit) {
		final MedicalVisit r = transform(medicalVisit);
		medicalDao.save(r);
		
	}

	@Override
	public void delete(Integer id) {
		medicalDao.delete(id);
		
	}


	
	@Override
	public List<MedicalVisitDTO> findVisitForIdDoctor(Integer idDoctor) {
		
		final Iterable<MedicalVisit> findAll=medicalDao.findAll();
		final List<MedicalVisitDTO> res=new ArrayList<>();
		findAll.forEach(mv->
		{
			/*if(mv.getDoctor().getId()==idDoctor)
			{
				final MedicalVisitDTO mvDTO = transform(mv);
				res.add(mvDTO);
			}*/
		});
		return res;
	}

}
