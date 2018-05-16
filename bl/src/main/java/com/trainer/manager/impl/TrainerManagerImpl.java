package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.TrainerDao;
import com.trainer.dto.Trainer;
import com.trainer.entity.TrainerEntity;
import com.trainer.manaager.TrainerManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class TrainerManagerImpl implements TrainerManager{

	@Autowired
	private TrainerDao m_trainerDao;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public Trainer get(Integer id) {
		return ModelPersister.get(id, m_trainerDao, m_dtoVisitor);
	}

	@Override
	public List<Trainer> getAll() {
		List<Trainer> results = new ArrayList<Trainer>();
		
		for (TrainerEntity trainer : m_trainerDao.getAll())
			results.add(convert(trainer));
		
		return results;
	}

	@Override
	public List<TrainerEntity> getAllEntities() {
		return m_trainerDao.getAll();
	}

	@Override
	public TrainerEntity getEntity(Integer id) {
		return m_trainerDao.get(id);
	}

	@Override
	public Trainer save(Trainer dto) {
		TrainerEntity convert = convert(dto);
		convert = m_trainerDao.save(convert);
		return convert(convert);
	}

	@Override
	public TrainerEntity saveEntity(TrainerEntity entity) {
		return m_trainerDao.save(entity);
	}

	@Override
	public void delete(Integer id) {
		m_trainerDao.delete(id);
	}

	//TODO: to remove and change to visitor
	private TrainerEntity convert(Trainer dto) {
		TrainerEntity result = new TrainerEntity();
		return result;
	}
	
	//TODO: to remove and change to visitor
	private Trainer convert(TrainerEntity entity) {
		return null;
	}

}
