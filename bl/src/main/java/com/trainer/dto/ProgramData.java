package com.trainer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProgramData implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<WorkoutData> workouts = new ArrayList<WorkoutData>();

	public List<WorkoutData> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutData> workouts) {
		this.workouts = workouts;
	}
	
}



