package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.List;

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
		List<Excersice> results = new ArrayList<Excersice>();
		
		for (ExcersiceEntity excersice : m_excersiceDao.getAll())
			results.add((Excersice) m_dtoVisitor.visit(excersice));
		
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
		ExcersiceEntity entity = (ExcersiceEntity) m_entityVistor.visit(dto.getId() == null ? new ExcersiceEntity() : getEntity(dto.getId()), dto);
		entity = m_excersiceDao.save(entity);
		return (Excersice) m_dtoVisitor.visit(entity);
	}

	@Override
	public ExcersiceEntity saveEntity(ExcersiceEntity entity) {
		return m_excersiceDao.save(entity);
	}

	@Override
	public void delete(Integer id) {
		m_excersiceDao.delete(id);
	}
}
