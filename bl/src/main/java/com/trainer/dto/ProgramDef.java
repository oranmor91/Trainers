package com.trainer.dto;

import java.util.ArrayList;
import java.util.List;


public class ProgramDef extends BaseDto {
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private String notes;

	private List<Workout> workouts = new ArrayList<Workout>();

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Workout> getWorkout() {
		return workouts;
	}

	public void setExcersices(List<Workout> workouts) {
		this.workouts = workouts;
	}

}
