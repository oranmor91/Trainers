package com.trainer.dto;

import java.io.Serializable;

import com.trainer.types.MuscleType;

public class Excersice implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;

	private MuscleType primaryMuscle;
	
	private String comment;
	
	private String videoURL;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
