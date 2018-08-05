package com.trainer.dto;

import java.io.Serializable;

public class RMData implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer  workoutId;
	
	private Integer excersiceWorkoutId;

	private Integer data;

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getExcersiceWorkoutId() {
		return excersiceWorkoutId;
	}

	public void setExcersiceWorkoutId(Integer excersiceWorkoutId) {
		this.excersiceWorkoutId = excersiceWorkoutId;
	}
}
