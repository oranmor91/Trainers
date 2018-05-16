package com.trainer.visitors.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trainer.dto.Excersice;
import com.trainer.entity.ExcersiceEntity;
import com.trainer.entity.ExcersiceWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.TrainerEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.entity.WorkoutProgramEntity;
import com.trainer.visitors.BaseVisitor;

@Component
@Qualifier("EntityVisitor")
public class EntityVisitor implements BaseVisitor{

	@Override
	public Object visit(TrainerEntity entity, Object... obj) {
		//TODO!
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WorkoutProgramEntity workoutProgramEntity, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
