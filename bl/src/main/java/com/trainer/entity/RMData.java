package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RMData{

	@Column
	private WorkoutEntity workout;
	
	@Column
	private ExerciseWorkoutEntity excersiceWorkout;
	
	@Column
	private Integer data;

	public WorkoutEntity getWorkout() {
		return workout;
	}

	public void setWorkout(WorkoutEntity workout) {
		this.workout = workout;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public ExerciseWorkoutEntity getExcersiceWorkout() {
		return excersiceWorkout;
	}

	public void setExcersiceWorkout(ExerciseWorkoutEntity excersiceWorkout) {
		this.excersiceWorkout = excersiceWorkout;
	}
}
