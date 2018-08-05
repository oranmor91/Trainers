package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ExcersiceDao;
import com.trainer.dto.Excersice;
import com.trainer.entity.ExerciseEntity;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ExcersiceManager;
import com.trainer.manaager.UserManager;
import com.trainer.manaager.WorkoutManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class ExcersiceManagerImpl extends BaseManager implements ExcersiceManager{

	@Autowired
	private ExcersiceDao m_excersiceDao;
	
	@Autowired
	private UserManager m_userManager;
	
	@Autowired
	private WorkoutManager m_workoutManager;
	
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
		List<Excersice> excersices = ModelPersister.getAll(m_excersiceDao, m_dtoVisitor);
		filterDtosByCoach(excersices, m_userManager);
		return excersices;
	}

	@Override
	public List<ExerciseEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_excersiceDao);
	}
	
	@Override
	public ExerciseEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_excersiceDao);
	}

	@Override
	@Transactional
	public Excersice save(Excersice dto) {
		setCoachId(dto, m_userManager);
		return ModelPersister.save(dto, new ExerciseEntity(), m_excersiceDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	@Transactional
	public ExerciseEntity saveEntity(ExerciseEntity entity) {
		return ModelPersister.saveEntity(entity, m_excersiceDao);
	}

	@Override
	@Transactional
	public void delete(Integer id) throws Exception {
		checkConnectedEntities(id);
		ModelPersister.delete(id, m_excersiceDao);
	}

	private void checkConnectedEntities(Integer id) throws Exception {
		
		for (WorkoutEntity workout : m_workoutManager.getAllEntities()) {
			for (ExerciseWorkoutEntity excersice : workout.getExcersices()) {
				if (excersice.getExercise().getId() == id)
					throw new Exception("Can not delete Excersice please remove link from workout named: " + workout.getName());
			}
		}
	}
}
