package com.trainer.dto;

import java.sql.Date;

public class PersonalProgram extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Integer trainerId;
	
	private Integer programDefId;
	
	private String name;
	
	private String description;
	
	private String notes;
	
	private Date startDate;
	
	private PersonalProgramData data;

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

	public PersonalProgramData getData() {
		return data;
	}

	public void setData(PersonalProgramData data) {
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
}
