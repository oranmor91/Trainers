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
@Qualifier("DtoVisitor")
public class DtoVisitor implements BaseVisitor{

	//TODO
	@Override
	public Object visit(TrainerEntity entity, Object... obj) {
		//TODO!
		return null;
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
