package com.trainer.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.WorkoutDao;
import com.trainer.dto.Workout;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.WorkoutManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class WorkoutManagerImpl implements WorkoutManager{

	@Autowired
	private WorkoutDao m_workoutDao;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public Workout get(Integer id) {
		return ModelPersister.get(id, m_workoutDao, m_dtoVisitor);
	}
	
	@Override
	public List<Workout> getAll() {
		return ModelPersister.getAll(m_workoutDao, m_dtoVisitor);
	}

	@Override
	public List<WorkoutEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_workoutDao);
	}
	
	@Override
	public WorkoutEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_workoutDao);
	}

	@Override
	public Workout save(Workout dto) {
		return ModelPersister.save(dto, new WorkoutEntity(), m_workoutDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	public WorkoutEntity saveEntity(WorkoutEntity entity) {
		return ModelPersister.saveEntity(entity, m_workoutDao);
	}

	@Override
	public void delete(Integer id) {
		ModelPersister.delete(id, m_workoutDao);
	}

}
