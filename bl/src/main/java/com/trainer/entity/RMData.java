package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RMData{

	@Column
	private WorkoutEntity workout;
	
	@Column
	private ExcersiceWorkoutEntity excersice;
	
	@Column
	private Integer data;

	public WorkoutEntity getWorkout() {
		return workout;
	}

	public void setWorkout(WorkoutEntity workout) {
		this.workout = workout;
	}

	public ExcersiceWorkoutEntity getExcersice() {
		return excersice;
	}

	public void setExcersice(ExcersiceWorkoutEntity excersice) {
		this.excersice = excersice;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}
