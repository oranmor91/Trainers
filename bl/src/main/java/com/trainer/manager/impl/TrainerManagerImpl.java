package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.TrainerDao;
import com.trainer.dto.Excersice;
import com.trainer.dto.Trainer;
import com.trainer.entity.ExcersiceEntity;
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
			results.add((Trainer)m_dtoVisitor.visit(trainer));
		
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
		TrainerEntity entity = (TrainerEntity)m_entityVistor.visit(dto.getId() == null ? new TrainerEntity() : getEntity(dto.getId()), dto);
		entity = m_trainerDao.save(entity);
		return (Trainer) m_dtoVisitor.visit(entity);
	}
	

	@Override
	public TrainerEntity saveEntity(TrainerEntity entity) {
		return m_trainerDao.save(entity);
	}

	@Override
	public void delete(Integer id) {
		m_trainerDao.delete(id);
	}
}
