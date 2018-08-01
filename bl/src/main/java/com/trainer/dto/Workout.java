package com.trainer.dto;

import java.util.ArrayList;
import java.util.List;

public class Workout extends BaseDto{

	private static final long serialVersionUID = 1L;

	private String name;

	private List<ExcersiceWorkout> exercises = new ArrayList<ExcersiceWorkout>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExcersiceWorkout> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExcersiceWorkout> exercises) {
		this.exercises = exercises;
	}
}
