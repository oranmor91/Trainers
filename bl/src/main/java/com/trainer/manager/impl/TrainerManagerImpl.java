package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

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
	public List<TrainerEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_trainerDao);
	}

	@Override
	public TrainerEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_trainerDao);
	}
	
	@Override
	@Transactional
	public TrainerEntity saveEntity(TrainerEntity entity) {
		return ModelPersister.saveEntity(entity, m_trainerDao);
	}

	@Override
	public Trainer get(Integer id) {
		return ModelPersister.get(id, m_trainerDao, m_dtoVisitor);
	}

	@Override
	public List<Trainer> getAll() {
		return ModelPersister.getAll(m_trainerDao, m_dtoVisitor);
	}

	@Override
	@Transactional
	public Trainer save(Trainer dto) {
		return ModelPersister.save(dto, new TrainerEntity(), m_trainerDao, m_dtoVisitor, m_entityVistor);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		ModelPersister.delete(id, m_trainerDao);
	}
}
