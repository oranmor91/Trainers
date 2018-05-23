package com.trainer.dto;

import java.io.Serializable;

import com.trainer.types.MuscleType;

public class ExcersiceData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private Integer id;
	
	private Integer numOfSets; 
	
	private Integer numOfIntervals;

	private Integer weight;

	private MuscleType primaryMuscle;
	
	private String comment;
	
	private String videoURL;
	
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public MuscleType getPrimaryMuscle() {
		return primaryMuscle;
	}

	public void setPrimaryMuscle(MuscleType primaryMuscle) {
		this.primaryMuscle = primaryMuscle;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
}
