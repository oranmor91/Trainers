package com.trainer.visitors;

import com.trainer.entity.ExerciseEntity;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.ProgramEntity;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.entity.ProgramDefEntity;

public interface BaseVisitor {

	public Object visit(UserEntity entity, Object... obj);
	
	public Object visit(ExerciseEntity entity, Object... obj);

	public Object visit(ExerciseWorkoutEntity excersiceWorkoutEntity, Object... obj);

	public Object visit(NutritionEntity nutritionEntity, Object... obj);

	public Object visit(WorkoutEntity workoutEntity, Object... obj);

	public Object visit(ProgramDefEntity workoutProgramEntity, Object... obj);

	public Object visit(ProgramEntity personalProgramEntity, Object... obj);


}
