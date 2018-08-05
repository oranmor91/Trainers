package com.trainer.dto;

import java.util.ArrayList;
import java.util.List;

public class Workout extends BaseDto{

	private static final long serialVersionUID = 1L;

	private String name;

	private List<ExerciseWorkout> exercises = new ArrayList<ExerciseWorkout>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExerciseWorkout> getExercise() {
		return exercises;
	}

	public void setExercises(List<ExerciseWorkout> exercises) {
		this.exercises = exercises;
	}
}
