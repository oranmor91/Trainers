package com.trainer.visitors;

import com.trainer.entity.ExcersiceEntity;
import com.trainer.entity.ExcersiceWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.TrainerEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.entity.WorkoutProgramEntity;

public interface BaseVisitor {

	public Object visit(TrainerEntity entity, Object... obj);
	
	public Object visit(ExcersiceEntity entity, Object... obj);

	public Object visit(ExcersiceWorkoutEntity excersiceWorkoutEntity, Object... obj);

	public Object visit(NutritionEntity nutritionEntity, Object... obj);

	public Object visit(WorkoutEntity workoutEntity, Object... obj);

	public Object visit(WorkoutProgramEntity workoutProgramEntity, Object... obj);


}
