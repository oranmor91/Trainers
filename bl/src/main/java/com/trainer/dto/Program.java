package com.trainer.dto;

import java.util.Date;

public class Program extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Integer trainerId;
	
	private Integer programDefId;
	
	private String name;
	
	private String description;
	
	private String notes;
	
	private Date startDate;
	
	private ProgramData data;
	
	private boolean rmFilled;
	
	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public Integer getProgramDefId() {
		return programDefId;
	}

	public void setProgramDefId(Integer programDefId) {
		this.programDefId = programDefId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ProgramData getData() {
		return data;
	}

	public void setData(ProgramData data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isRmFilled() {
		return rmFilled;
	}

	public void setRmFilled(boolean rmFilled) {
		this.rmFilled = rmFilled;
	}
}
