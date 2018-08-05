package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RMData{

	@Column
	private Integer workoutId;
	
	@Column
	private Integer excersiceWorkout;
	
	@Column
	private Integer data;

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public Integer getExcersiceWorkout() {
		return excersiceWorkout;
	}

	public void setExcersiceWorkout(Integer excersiceWorkout) {
		this.excersiceWorkout = excersiceWorkout;
	}
}
