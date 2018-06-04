package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ProgramDefDao;
import com.trainer.dto.ProgramDef;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.manaager.ProgramDefManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class ProgramDefManagerImpl extends BaseManager implements ProgramDefManager{

	@Autowired
	private ProgramDefDao m_ProgramDefDao;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public ProgramDef get(Integer id) {
		return ModelPersister.get(id, m_ProgramDefDao, m_dtoVisitor);
	}
	
	@Override
	public List<ProgramDef> getAll() {
		return ModelPersister.getAll(getLoggedInUser(), m_ProgramDefDao, m_dtoVisitor);
	}

	@Override
	public List<ProgramDefEntity> getAllEntities() {
		return ModelPersister.getAllEntities(getLoggedInUser(), m_ProgramDefDao);
	}
	
	@Override
	public ProgramDefEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_ProgramDefDao);
	}

	@Override
	@Transactional
	public ProgramDef save(ProgramDef dto) {
		return ModelPersister.save(dto, getLoggedInUser(), new ProgramDefEntity(), m_ProgramDefDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	@Transactional
	public ProgramDefEntity saveEntity(ProgramDefEntity entity) {
		return ModelPersister.saveEntity(entity, m_ProgramDefDao);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ModelPersister.delete(id, m_ProgramDefDao);
	}

}
