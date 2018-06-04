package com.trainer.dto;

import java.util.ArrayList;
import java.util.List;

public class Workout extends BaseDto{

	private static final long serialVersionUID = 1L;

	private String name;

	private List<ExcersiceWorkout> excersices = new ArrayList<ExcersiceWorkout>();
	
	private Integer coachId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExcersiceWorkout> getExcersices() {
		return excersices;
	}

	public void setExcersices(List<ExcersiceWorkout> excersices) {
		this.excersices = excersices;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
}
