package com.trainer.visitors.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trainer.dto.Excersice;
import com.trainer.dto.ExerciseWorkout;
import com.trainer.dto.Program;
import com.trainer.dto.ProgramDef;
import com.trainer.dto.RMData;
import com.trainer.dto.User;
import com.trainer.dto.Workout;
import com.trainer.entity.ExerciseEntity;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.entity.ProgramEntity;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ExcersiceManager;
import com.trainer.manaager.ProgramManager;
import com.trainer.manaager.UserManager;
import com.trainer.manaager.WorkoutManager;
import com.trainer.visitors.BaseVisitor;

@Component
@Qualifier("EntityVisitor")
public class EntityVisitor implements BaseVisitor{

	@Autowired
	private ExcersiceManager m_excersiceManager;
	
	@Autowired
	private WorkoutManager m_workoutManager;
	
	@Autowired
	private ProgramManager m_programManager;
	
	@Autowired
	private UserManager m_userManager;
	
	@Override
	public Object visit(UserEntity entity, Object... obj) {
		User dto = (User) obj[0];
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setGender(dto.getGender());
		entity.setBirthDay(dto.getBirthDay());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setAddress(dto.getAddress());
		entity.setHeight(dto.getHeight());
		entity.setWeight(dto.getWeight());
		entity.setNumOfExperience(dto.getNumOfExperience());
		entity.setEmail(dto.getEmail());
		
		entity.getRoles().clear();
		entity.getRoles().addAll(dto.getRoles());
		
		Integer coachId = dto.getCoachId();
		
		if (coachId != null)
			entity.setCoach(m_userManager.getEntity(coachId));
		return entity;
	}

	@Override
	public Object visit(ExerciseEntity entity, Object... obj) {
		Excersice dto = (Excersice) obj[0];
		entity.setId(dto.getId());
		entity.setComment(dto.getComment());
		entity.setName(dto.getName());
		entity.setPrimaryMuscle(dto.getPrimaryMuscle());
		entity.setVideoURL(dto.getVideoURL());
		entity.setCoach(m_userManager.getEntity(dto.getCoachId()));
		return entity;
	}

	@Override
	public Object visit(ExerciseWorkoutEntity excersiceWorkoutEntity, Object... obj) {
		ExerciseWorkout dto = (ExerciseWorkout) obj[0];
		Integer excersiceId = dto.getExcersiceId();
		
		if (excersiceId == null)
			return null;
		
		ExerciseEntity entity = m_excersiceManager.getEntity(excersiceId);
		
		if (entity == null)
			return null;
		
		excersiceWorkoutEntity.setId(dto.getId());
		excersiceWorkoutEntity.setExercise(entity);
		excersiceWorkoutEntity.setNumOfIntervals(dto.getNumOfIntervals());
		excersiceWorkoutEntity.setNumOfSets(dto.getNumOfSets());
		excersiceWorkoutEntity.setCoach(m_userManager.getEntity(dto.getCoachId()));		
		return excersiceWorkoutEntity;
	}

	@Override
	public Object visit(WorkoutEntity workoutEntity, Object... obj) {
		Workout dto = (Workout) obj[0];
		workoutEntity.setId(dto.getId());
		workoutEntity.setName(dto.getName());
		workoutEntity.setCoach(m_userManager.getEntity(dto.getCoachId()));
		workoutEntity.getExcersices().clear();
		
		for (ExerciseWorkout excersiceWorkout : dto.getExercise()) {
			ExerciseWorkoutEntity entity = (ExerciseWorkoutEntity) visit(new ExerciseWorkoutEntity(), excersiceWorkout);
			
			if (entity != null)
				workoutEntity.getExcersices().add(entity);	
		}
				
		return workoutEntity;
	}
	
	@Override
	public Object visit(NutritionEntity nutritionEntity, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProgramDefEntity workoutProgramEntity, Object... obj) {
		ProgramDef dto = (ProgramDef) obj[0];
		workoutProgramEntity.setId(dto.getId());
		workoutProgramEntity.setDescription(dto.getDescription());
		workoutProgramEntity.setName(dto.getName());
		workoutProgramEntity.setNotes(dto.getNotes());
		workoutProgramEntity.setCoach(m_userManager.getEntity(dto.getCoachId()));
		
		workoutProgramEntity.getWorkouts().clear();
		
		for (Integer workoutId : dto.getWorkouts()) {
			WorkoutEntity workoutEntity = m_workoutManager.getEntity(workoutId);
			
			if (workoutEntity != null)
				workoutProgramEntity.getWorkouts().add(workoutEntity);
		}
		
		return workoutProgramEntity;
	}

	@Override
	public Object visit(ProgramEntity personalProgramEntity, Object... obj) {
		Program dto = (Program) obj[0];
		
		personalProgramEntity.setId(dto.getId());
		personalProgramEntity.setName(dto.getName());
		personalProgramEntity.setData(dto.getData());
		personalProgramEntity.setStartDate(dto.getStartDate());
		
		ProgramDefEntity defEntity = m_programManager.getDefEntity(dto.getProgramDefId());
		personalProgramEntity.setParentDef(defEntity);
		
		UserEntity coachEntity = m_userManager.getEntity(dto.getCoachId());
		personalProgramEntity.setCoach(coachEntity);
		
		UserEntity trainerEntity = m_userManager.getEntity(dto.getTrainerId());
		personalProgramEntity.setTrainer(trainerEntity);
		
		for (RMData rmData : dto.getRmData())
			personalProgramEntity.getRmData().add(visit(rmData));
		
		return personalProgramEntity;
	}

	private com.trainer.entity.RMData visit(RMData rmData) {
		com.trainer.entity.RMData result = new com.trainer.entity.RMData();
		result.setData(rmData.getData());
		result.setExcersiceWorkout(m_workoutManager.getExcersiceWorkoutEntity(rmData.getExcersiceWorkoutId()));
		result.setWorkout(m_workoutManager.getEntity(rmData.getWorkoutId()));
		return result;
	}
}
