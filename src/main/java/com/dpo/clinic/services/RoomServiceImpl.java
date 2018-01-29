package com.dpo.clinic.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpo.clinic.dao.RoomDao;
import com.dpo.clinic.dto.RoomDTO;
import com.dpo.clinic.model.Room;
@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private DozerBeanMapper dozer=new DozerBeanMapper();
	
	@Override
	public RoomDTO transform(Room room) {
		return dozer.map(room, RoomDTO.class);
	}

	@Override
	public Room transform(RoomDTO room) {
		return dozer.map(room, Room.class);
	}

	@Override
	public List<RoomDTO> findAll() {
		final Iterable<Room> findAll = roomDao.findAll();
		final List<RoomDTO> res = new ArrayList<>();
		findAll.forEach(r -> {
			final RoomDTO rDTO = transform(r);
			res.add(rDTO);
		});
		return res;
	}

	@Override
	public RoomDTO findById(Integer id) {
		final Room r=roomDao.findOne(id);
		return transform(r);
	}

	@Override
	public RoomDTO create(RoomDTO room) {
		final Room r=transform(room);
		return transform(roomDao.save(r));
	}

	@Override
	public void update(RoomDTO room) {
		final Room r = transform(room);
		roomDao.save(r);
		
	}

	@Override
	public void delete(Integer id) {
		roomDao.delete(id);
		
	}

	@Override
	public List<RoomDTO> findAllByClinic(Integer idClinic) {
		final Iterable<Room> findAll = roomDao.findAll();
		final List<RoomDTO> res = new ArrayList<>();
		findAll.forEach(r -> 
		{
			if(r.getClinic().getId()==idClinic)
			{
				final RoomDTO rDTO = transform(r);
				res.add(rDTO);
			}
			
		});
		return res;
	}

	
}
