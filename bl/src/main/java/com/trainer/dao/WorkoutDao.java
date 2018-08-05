package com.trainer.dao;

import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.WorkoutEntity;

public interface WorkoutDao extends BaseDao<WorkoutEntity>{

	public ExerciseWorkoutEntity getExcersiceWorkoutEntity(Integer id);

}
