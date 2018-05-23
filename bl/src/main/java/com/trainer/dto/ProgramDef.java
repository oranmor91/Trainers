package com.trainer.dto;

import java.util.ArrayList;
import java.util.List;


public class ProgramDef extends BaseDto {
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private String notes;

	private List<Integer> workouts = new ArrayList<Integer>();

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

	public List<Integer> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Integer> workouts) {
		this.workouts = workouts;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
