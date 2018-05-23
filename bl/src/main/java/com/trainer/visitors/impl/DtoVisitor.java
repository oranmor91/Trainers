package com.trainer.visitors.impl;

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
import com.trainer.entity.ProgramDefEntity;
import com.trainer.visitors.BaseVisitor;

@Component
@Qualifier("DtoVisitor")
public class DtoVisitor implements BaseVisitor{

	@Override
	public Object visit(TrainerEntity entity, Object... obj) {
		Trainer dto = new Trainer();
		dto.setAdress(entity.getAdress());
		dto.setBirthDay(entity.getBirthDay());
		dto.setFirstName(entity.getFirstName());
		dto.setGender(entity.getGender());
		dto.setHeight(entity.getHeight());
		dto.setId(entity.getId());
		dto.setLastName(entity.getLastName());
		dto.setNumOfExpeirence(entity.getNumOfExpeirence());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setWeight(entity.getWeight());
		
		for (NutritionEntity nutrion : entity.getNutrions())
			dto.getNutritionId().add(nutrion.getId());
		
		return dto;
	}

	@Override
	public Object visit(ExcersiceEntity entity, Object... obj) {
		Excersice dto = new Excersice();
		dto.setId(entity.getId());
		dto.setComment(entity.getComment());
		dto.setName(entity.getName());
		dto.setPrimaryMuscle(entity.getPrimaryMuscle());
		dto.setVideoURL(entity.getVideoURL());
		return dto;
	}

	@Override
	public Object visit(ExcersiceWorkoutEntity excersiceWorkoutEntity, Object... obj) {
		ExcersiceWorkout workoutExcersice = new ExcersiceWorkout();
		workoutExcersice.setId(excersiceWorkoutEntity.getId());
		workoutExcersice.setExcersiceId(excersiceWorkoutEntity.getExcersice().getId());
		workoutExcersice.setNumOfIntervals(excersiceWorkoutEntity.getNumOfIntervals());
		workoutExcersice.setNumOfSets(excersiceWorkoutEntity.getNumOfSets());
		return workoutExcersice;
	}

	@Override
	public Object visit(NutritionEntity nutritionEntity, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WorkoutEntity workoutEntity, Object... obj) {
		Workout dto = new Workout();
		dto.setId(workoutEntity.getId());
		dto.setName(workoutEntity.getName());
		
		for (ExcersiceWorkoutEntity excersice : workoutEntity.getExcersices()) {
			ExcersiceWorkout workoutExcersice = (ExcersiceWorkout) excersice.accept(this, excersice);
			dto.getExcersices().add(workoutExcersice);
		}
		
		return dto;
	}

	@Override
	public Object visit(ProgramDefEntity workoutProgramEntity, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
