package com.dpo.clinic.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dpo.clinic.dao.DoctorDao;
import com.dpo.clinic.dto.DoctorDTO;
import com.dpo.clinic.model.Doctor;
@Service
public class DoctorServiceImpl implements DoctorService {

	private static final Logger log = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Autowired
	private DoctorDao doctorDao;


	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public DoctorDTO transform(Doctor doctor) {

		return dozer.map(doctor, DoctorDTO.class);
	}

	@Override
	public Doctor transform(DoctorDTO doctor) {
		return dozer.map(doctor, Doctor.class);

	}

	@Override
	public List<DoctorDTO> findAll() {
		log.debug("Mostrando todos los doctores");
		
		final Iterable<Doctor> findAll = doctorDao.findAll();
		final List<DoctorDTO> res = new ArrayList<>();
		findAll.forEach(d -> {
			final DoctorDTO dDTO = transform(d);
			res.add(dDTO);
		});
	
		return res;
	}

	@Override
	public DoctorDTO findById(Integer id) {
		final Doctor d = doctorDao.findOne(id);
		return transform(d);
	}

	@Override
	public DoctorDTO create(DoctorDTO doctor) {
		final Doctor d = transform(doctor);
		return transform(doctorDao.save(d));
	}

	@Override
	public void update(DoctorDTO doctor) {
		final Doctor d = transform(doctor);
		doctorDao.save(d);

	}

	@Override
	public void delete(Integer id) {
		doctorDao.delete(id);

	}

	@Override
	public Integer getVisitForDoctorId(DoctorDTO doctor) {
		return doctorDao.numberOfVisit(this.transform(doctor));
	}

	@Override
	public Integer[] getTopDoctors(Integer limit) 
	{
		
		return doctorDao.doctorsTop();
	}
	
	/*
	 * FUNCIÓN QUE SE CONECTA A LA API DE DAVID
	 * NO REALIZO VOLCADO DE DATOS EN MI BD, TENGO UN CAMPO EN MI BD CON EL MISMO ID QUE EL ID DE LA API
	 * NI GUARDO LOS PRECIOS ACTUALIZADOS EN MI BD, LOS CARGO EN LA BD CONFORME ME VA HACIENDO FALTA
	 */
	@Override
	public Float getSalaryDoctor(DoctorDTO doctor) 
	{
		RestTemplate res=new RestTemplate();
		DoctorDTO[] response=res.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?size=12", DoctorDTO[].class);
		Float price = new Float(0.0);
		
		for(Integer i=0;i<response.length;i++)
		{
			if(doctor.getIdApi().equals(response[i].getId()))
				price=getTarifaDoctor(response[i].getId().toString());
		}

		return (price*getVisitForDoctorId(doctor));
	}
	
	private Float getTarifaDoctor(String doctorID)
	{
		RestTemplate res=new RestTemplate();
		//Difereciamos si pasamos un doctor de la APi o un doctor nuestro

		DoctorDTO doctorApi=res.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/"+doctorID, DoctorDTO.class);
		return doctorApi.getPrice();
	}

	@Override
	public Float getSalaryDoctorDate(DoctorDTO doctor,String dateInit,String dateEnd) throws ParseException 
	{
		//ParsearLasfechas
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

		Date init=format.parse(dateInit);
		Date end=format.parse(dateEnd);
		
		return (float) doctorDao.numberOfVisitForDate(this.transform(doctor),init,end)*getTarifaDoctor(doctor.getIdApi());

	}




}
