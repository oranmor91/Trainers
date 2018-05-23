package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.trainer.entity.ExcersiceEntity;
import com.trainer.entity.ExcersiceWorkoutEntity;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ExcersiceManager;
import com.trainer.manaager.ProgramDefManager;
import com.trainer.manaager.StartUpManager;
import com.trainer.manaager.WorkoutManager;
import com.trainer.types.MuscleType;

@Component
@Scope("singleton")
public class StartUpManagerImpl implements StartUpManager{

	@Autowired
	private ExcersiceManager m_excersiceManager;
	
	@Autowired
	private WorkoutManager m_workoutManager;
	
	@Autowired
	private ProgramDefManager m_programDefManager;
	
	@Transactional
	public void start() {
		List<ExcersiceEntity> allEntities = m_excersiceManager.getAllEntities();
		
		if (!allEntities.isEmpty())
			return;
		
		ExcersiceEntity excersiceEntity = new ExcersiceEntity();
		excersiceEntity.setName("sqat");
		excersiceEntity.setPrimaryMuscle(MuscleType.LEG);
		excersiceEntity = m_excersiceManager.saveEntity(excersiceEntity);
		
		WorkoutEntity workoutEntity = new WorkoutEntity();
		workoutEntity.setName("ALL");
		ExcersiceWorkoutEntity excerWorkoutEntity = new ExcersiceWorkoutEntity();
		excerWorkoutEntity.setExcersice(excersiceEntity);
		excerWorkoutEntity.setNumOfIntervals(2);
		excerWorkoutEntity.setNumOfSets(3);
		workoutEntity.getExcersices().add(excerWorkoutEntity);
		workoutEntity = m_workoutManager.saveEntity(workoutEntity);
		
		ProgramDefEntity progDefEntity = new ProgramDefEntity();
		progDefEntity.setDescription("bla bla i am a prog def");
		progDefEntity.setName("General Program");
		progDefEntity.setNotes("Do IT!");
		progDefEntity.getWorkouts().add(workoutEntity);
		m_programDefManager.saveEntity(progDefEntity);
	}

}
