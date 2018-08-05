package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ExerciseWorkoutDao;
import com.trainer.dao.WorkoutDao;
import com.trainer.dto.ExerciseWorkout;
import com.trainer.dto.ProgramDef;
import com.trainer.dto.Workout;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ProgramManager;
import com.trainer.manaager.UserManager;
import com.trainer.manaager.WorkoutManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class WorkoutManagerImpl extends BaseManager implements WorkoutManager{

	@Autowired
	private WorkoutDao m_workoutDao;
	
	@Autowired
	private UserManager m_userManager;
	
	@Autowired
	private ProgramManager m_programManager;
	
	@Autowired
	private ExerciseWorkoutDao m_exerciseWorkoutDao;
	
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
		List<Workout> workouts = ModelPersister.getAll(m_workoutDao, m_dtoVisitor);
		filterDtosByCoach(workouts, m_userManager);
		return workouts;
	}

	@Override
	public List<WorkoutEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_workoutDao);
	}
	
	@Override
	public ExerciseWorkoutEntity getExcersiceWorkoutEntity(Integer id) {
		return m_exerciseWorkoutDao.get(id);
	}
	
	@Override
	public WorkoutEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_workoutDao);
	}

	@Override
	@Transactional
	public Workout save(Workout dto) {
		setCoachId(dto, m_userManager);
		UserEntity caoch = m_userManager.getUserEntityByUniqueID(getLoggedInUser());
		
		for (ExerciseWorkout ex : dto.getExercise())
			ex.setCoachId(caoch.getId());
		
		return ModelPersister.save(dto, new WorkoutEntity(), m_workoutDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	@Transactional
	public WorkoutEntity saveEntity(WorkoutEntity entity) {
		return ModelPersister.saveEntity(entity, m_workoutDao);
	}

	@Override
	@Transactional
	public void delete(Integer id) throws Exception {
		checkConnectedEntities(id);
		ModelPersister.delete(id, m_workoutDao);
	}

	private void checkConnectedEntities(Integer id) throws Exception {
		for (ProgramDef programDef : m_programManager.getAllDef()) {
			if (programDef.getId() == id)
				throw new Exception("Can not delete workout that connected to program with name: " + programDef.getName());
		}
	}
	
	

}
