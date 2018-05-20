package com.trainer.visitors.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trainer.dto.Excersice;
import com.trainer.dto.ExcersiceWorkout;
import com.trainer.dto.Trainer;
import com.trainer.dto.Workout;
import com.trainer.entity.ExcersiceEntity;
import com.trainer.entity.ExcersiceWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.TrainerEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ExcersiceManager;
import com.trainer.visitors.BaseVisitor;

@Component
@Qualifier("EntityVisitor")
public class EntityVisitor implements BaseVisitor{

	@Autowired
	private ExcersiceManager m_excersiceManager;
	
	@Override
	public Object visit(TrainerEntity entity, Object... obj) {
		Trainer dto = (Trainer) obj[0];
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NutritionEntity nutritionEntity, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WorkoutEntity workoutEntity, Object... obj) {
		Workout dto = (Workout) obj[0];
		workoutEntity.setId(dto.getId());
		workoutEntity.setName(dto.getName());

		workoutEntity.getExcersices().clear();
		
		for (ExcersiceWorkout excersiceWorkout : dto.getExcersices()) {
			Integer excersiceId = excersiceWorkout.getExcersiceId();
			
			if (excersiceId == null)
				continue;
			
			ExcersiceEntity entity = m_excersiceManager.getEntity(excersiceId);
			
			if (entity == null)
				continue;
			
			ExcersiceWorkoutEntity excersiceWorkoutEntity = new ExcersiceWorkoutEntity();
			excersiceWorkoutEntity.setId(excersiceWorkout.getId());
			excersiceWorkoutEntity.setExcersice(entity);
			excersiceWorkoutEntity.setNumOfIntervals(excersiceWorkout.getNumOfIntervals());
			excersiceWorkoutEntity.setNumOfSets(excersiceWorkout.getNumOfSets());
			workoutEntity.getExcersices().add(excersiceWorkoutEntity);	
		}
				
		return workoutEntity;
	}
}
