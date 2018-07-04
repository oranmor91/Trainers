package com.trainer.visitors.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trainer.dto.Excersice;
import com.trainer.dto.ExcersiceWorkout;
import com.trainer.dto.Program;
import com.trainer.dto.ProgramDef;
import com.trainer.dto.User;
import com.trainer.dto.Workout;
import com.trainer.entity.ExcersiceEntity;
import com.trainer.entity.ExcersiceWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.ProgramEntity;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.entity.ProgramDefEntity;
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
		entity.setAdress(dto.getAdress());
		entity.setHeight(dto.getHeight());
		entity.setWeight(dto.getWeight());
		entity.setNumOfExpeirence(dto.getNumOfExpeirence());
		entity.setEmail(dto.getEmail());
		return entity;
	}

	@Override
	public Object visit(ExcersiceEntity entity, Object... obj) {
		Excersice dto = (Excersice) obj[0];
		entity.setId(dto.getId());
		entity.setComment(dto.getComment());
		entity.setName(dto.getName());
		entity.setPrimaryMuscle(dto.getPrimaryMuscle());
		entity.setVideoURL(dto.getVideoURL());
		return entity;
	}

	@Override
	public Object visit(ExcersiceWorkoutEntity excersiceWorkoutEntity, Object... obj) {
		ExcersiceWorkout dto = (ExcersiceWorkout) obj[0];
		Integer excersiceId = dto.getExcersiceId();
		
		if (excersiceId == null)
			return null;
		
		ExcersiceEntity entity = m_excersiceManager.getEntity(excersiceId);
		
		if (entity == null)
			return null;
		
		excersiceWorkoutEntity.setId(dto.getId());
		excersiceWorkoutEntity.setExcersice(entity);
		excersiceWorkoutEntity.setNumOfIntervals(dto.getNumOfIntervals());
		excersiceWorkoutEntity.setNumOfSets(dto.getNumOfSets());
		return excersiceWorkoutEntity;
	}

	@Override
	public Object visit(WorkoutEntity workoutEntity, Object... obj) {
		Workout dto = (Workout) obj[0];
		workoutEntity.setId(dto.getId());
		workoutEntity.setName(dto.getName());

		workoutEntity.getExcersices().clear();
		
		for (ExcersiceWorkout excersiceWorkout : dto.getExcersices()) {
			ExcersiceWorkoutEntity entity = (ExcersiceWorkoutEntity) visit(new ExcersiceWorkoutEntity(), excersiceWorkout);
			
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
		personalProgramEntity.getRmData().addAll(dto.getRmData());
		personalProgramEntity.setData(dto.getData());
		personalProgramEntity.setStartDate(dto.getStartDate());
		
		ProgramDefEntity defEntity = m_programManager.getDefEntity(dto.getProgramDefId());
		personalProgramEntity.setParentDef(defEntity);
		
		UserEntity coachEntity = m_userManager.getEntity(dto.getCoachId());
		personalProgramEntity.setCoach(coachEntity);
		
		UserEntity trainerEntity = m_userManager.getEntity(dto.getTrainerId());
		personalProgramEntity.setTrainer(trainerEntity);
		return personalProgramEntity;
	}
}
