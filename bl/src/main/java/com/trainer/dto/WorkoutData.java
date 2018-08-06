package com.trainer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkoutData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private Integer id;
	
	// ** change s
	private List<ExercisesData> exercise = new ArrayList<ExercisesData>();

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

	// ** change s
	public List<ExercisesData> getExercise() {
		return exercise;
	}

	// ** change s
	public void setExercises(List<ExercisesData> exercise) {
		this.exercise = exercise;
	}
	
}
