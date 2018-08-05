package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.Workout;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.WorkoutEntity;

public interface WorkoutManager {

	public Workout get(Integer id);
	
	public List<Workout> getAll();
	
	public List<WorkoutEntity> getAllEntities();
	
	public WorkoutEntity getEntity(Integer id);
	
	public Workout save(Workout dto);
	
	public WorkoutEntity saveEntity(WorkoutEntity entity);
	
	public void delete(Integer id) throws Exception;

	public ExerciseWorkoutEntity getExcersiceWorkoutEntity(Integer id);
}
