package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ExcersiceDao;
import com.trainer.dto.Excersice;
import com.trainer.entity.ExcersiceEntity;
import com.trainer.manaager.ExcersiceManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class ExcersiceManagerImpl implements ExcersiceManager{

	@Autowired
	private ExcersiceDao m_excersiceDao;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public Excersice get(Integer id) {
		return ModelPersister.get(id, m_excersiceDao, m_dtoVisitor);
	}
	
	@Override
	public List<Excersice> getAll() {
		return ModelPersister.getAll(m_excersiceDao, m_dtoVisitor);
	}

	@Override
	public List<ExcersiceEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_excersiceDao);
	}
	
	@Override
	public ExcersiceEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_excersiceDao);
	}

	@Override
	@Transactional
	public Excersice save(Excersice dto) {
		return ModelPersister.save(dto, new ExcersiceEntity(), m_excersiceDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	@Transactional
	public ExcersiceEntity saveEntity(ExcersiceEntity entity) {
		return ModelPersister.saveEntity(entity, m_excersiceDao);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ModelPersister.delete(id, m_excersiceDao);
	}
}
