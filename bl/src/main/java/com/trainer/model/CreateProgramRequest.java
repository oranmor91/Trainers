package com.trainer.model;

import java.io.Serializable;

public class CreateProgramRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String programName;

	private Integer programDefId;
	
	private Integer trainerId;

	public Integer getProgramDefId() {
		return programDefId;
	}

	public void setProgramDefId(Integer programDefId) {
		this.programDefId = programDefId;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
}
