package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ExcersiceDao;
import com.trainer.dto.Excersice;
import com.trainer.entity.ExcersiceEntity;
import com.trainer.manaager.ExcersiceManager;

@Service
@Scope("singleton")
public class ExcersiceManagerImpl implements ExcersiceManager{

	@Autowired
	private ExcersiceDao m_excersiceDao;
	
	@Override
	public Excersice get(Integer id) {
		ExcersiceEntity excersiceEntity = m_excersiceDao.get(id);
		return excersiceEntity == null ? null : convert(excersiceEntity); 
	}
	
	@Override
	public List<Excersice> getAll() {
		List<Excersice> results = new ArrayList<Excersice>();
		
		for (ExcersiceEntity excersice : m_excersiceDao.getAll())
			results.add(convert(excersice));
		
		return results;
	}

	@Override
	public List<ExcersiceEntity> getAllEntities() {
		return m_excersiceDao.getAll();
	}
	
	@Override
	public ExcersiceEntity getEntity(Integer id) {
		return m_excersiceDao.get(id);
	}

	@Override
	public Excersice save(Excersice dto) {
		ExcersiceEntity convert = convert(dto);
		convert = m_excersiceDao.save(convert);
		return convert(convert);
	}

	@Override
	public ExcersiceEntity saveEntity(ExcersiceEntity entity) {
		return m_excersiceDao.save(entity);
	}

	@Override
	public void delete(Integer id) {
		m_excersiceDao.delete(id);
	}

	private ExcersiceEntity convert(Excersice dto) {
		ExcersiceEntity result = new ExcersiceEntity();
		result.setId(dto.getId());
		result.setComment(dto.getComment());
		result.setName(dto.getName());
		result.setPrimaryMuscle(dto.getPrimaryMuscle());
		result.setVideoURL(dto.getVideoURL());
		return result;
	}
	
	private Excersice convert(ExcersiceEntity entity) {
		Excersice result = new Excersice();
		result.setComment(entity.getComment());
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPrimaryMuscle(entity.getPrimaryMuscle());
		result.setVideoURL(entity.getVideoURL());
		return result;
	}
}
