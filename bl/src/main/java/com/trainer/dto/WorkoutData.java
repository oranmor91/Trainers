package com.trainer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkoutData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private Integer id;
	
	private List<ExercisesData> exercises = new ArrayList<ExercisesData>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ExercisesData> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExercisesData> exercises) {
		this.exercises = exercises;
	}
	
}
