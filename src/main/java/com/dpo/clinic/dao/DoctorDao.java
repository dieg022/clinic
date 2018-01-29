package com.dpo.clinic.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dpo.clinic.model.Doctor;

@Repository
public interface DoctorDao extends CrudRepository<Doctor, Integer>
{
	/*
	 * Query que nos devuelve las consultas que un médico tiene en el sistema registradas.
	 */
	@Query(value="SELECT count(v.doctor) FROM Appoinment a, MedicalVisit v"
			+ " WHERE a.id=v.appoinment and v.doctor=:idDoctor")
	public Integer numberOfVisit(@Param(value="idDoctor") Doctor doctor);
	
	/*
	 * Query que nos devuelve el número de pacientes por Doctores.
	 */
	@Query(value="SELECT COUNT(a.patient) from MedicalVisit m,Appoinment a WHERE m.appoinment=a.id group by m.doctor ORDER BY numeroConsultas DESC")
	public  Integer[] doctorsTop();
	
	/*Query que nos devuelve el número de consultas por un Intervalo de Fechas*/
	@Query(value="select count(v.doctor)"
			+ " FROM Appoinment  a,MedicalVisit v"
			+ " WHERE a.id=v.appoinment AND v.doctor=:idDoctor AND a.date>=:dateInit AND a.date<=:dateEnd")
	public Integer numberOfVisitForDate(@Param(value="idDoctor") Doctor Doctor,@Param(value="dateInit") java.util.Date dateInit,@Param(value="dateEnd") java.util.Date dateEnd);
	
	
	
	
}
