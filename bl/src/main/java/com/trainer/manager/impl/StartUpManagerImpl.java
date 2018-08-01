package com.trainer.manager.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.trainer.manaager.ExcersiceManager;
import com.trainer.manaager.ProgramManager;
import com.trainer.manaager.StartUpManager;
import com.trainer.manaager.UserManager;
import com.trainer.manaager.WorkoutManager;

@Component
@Scope("singleton")
public class StartUpManagerImpl implements StartUpManager{

	@Autowired
	private ExcersiceManager m_excersiceManager;
	
	@Autowired
	private WorkoutManager m_workoutManager;
	
	@Autowired
	private ProgramManager m_programDefManager;
	
	@Autowired
	private UserManager m_trainerManager;
	
	@Transactional
	public void start() {
//		List<ExcersiceEntity> allEntities = m_excersiceManager.getAllEntities();
//		
//		if (!allEntities.isEmpty())
//			return;
		
		
//		UserEntity coach = new UserEntity();
//		coach.setFirstName("Super");
//		coach.setLastName("Admin");
//		coach.setGender(GenderType.MALE);
//		coach.setEmail("neri@gamil.com");
//		coach.getRoles().add(UserType.COACH);
//		coach.getRoles().add(UserType.TRAINER);
//		coach = m_trainerManager.saveEntity(coach);
//		
//		ExcersiceEntity excersiceEntity = new ExcersiceEntity();
//		excersiceEntity.setName("sqat");
//		excersiceEntity.setPrimaryMuscle(MuscleType.LEG);
//		excersiceEntity.setCoach(coach);
//		excersiceEntity = m_excersiceManager.saveEntity(excersiceEntity);
//		
//		WorkoutEntity workoutEntity = new WorkoutEntity();
//		workoutEntity.setName("ALL");
//		ExcersiceWorkoutEntity excerWorkoutEntity = new ExcersiceWorkoutEntity();
//		excerWorkoutEntity.setExcersice(excersiceEntity);
//		excerWorkoutEntity.setNumOfIntervals(2);
//		excerWorkoutEntity.setNumOfSets(3);
//		excerWorkoutEntity.setCoach(coach);
//		workoutEntity.getExcersices().add(excerWorkoutEntity);
//		workoutEntity.setCoach(coach);
//		workoutEntity = m_workoutManager.saveEntity(workoutEntity);
//		
//		ProgramDefEntity progDefEntity = new ProgramDefEntity();
//		progDefEntity.setDescription("bla bla i am a prog def");
//		progDefEntity.setName("General Program");
//		progDefEntity.setNotes("Do IT!");
//		progDefEntity.setCoach(coach);
//		progDefEntity.getWorkouts().add(workoutEntity);
//		m_programDefManager.saveDefEntity(progDefEntity);
	}

}
