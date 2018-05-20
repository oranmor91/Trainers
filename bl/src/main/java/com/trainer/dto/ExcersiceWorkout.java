package com.trainer.dto;

public class ExcersiceWorkout extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Integer excersiceId;
	
	private Integer numOfSets; 
	
	private Integer numOfIntervals;

	public ExcersiceWorkout() {}
	
	public ExcersiceWorkout(Integer excersiceId, Integer numOfSets, Integer numOfIntervals) {
		this.excersiceId = excersiceId;
		this.numOfSets= numOfSets;
		this.numOfIntervals = numOfIntervals;
	}
	
	public Integer getExcersiceId() {
		return excersiceId;
	}

	public void setExcersiceId(Integer excersiceId) {
		this.excersiceId = excersiceId;
	}

	public Integer getNumOfSets() {
		return numOfSets;
	}

	public void setNumOfSets(Integer numOfSets) {
		this.numOfSets = numOfSets;
	}

	public Integer getNumOfIntervals() {
		return numOfIntervals;
	}

	public void setNumOfIntervals(Integer numOfIntervals) {
		this.numOfIntervals = numOfIntervals;
	}
	
}
