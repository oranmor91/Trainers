package com.trainer.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.trainer.entity.RMData;

public class Program extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Integer trainerId;
	
	private Integer programDefId;
	
	private String name;
	
	private String description;
	
	private String notes;
	
	private Date startDate;
	
	private ProgramData data;
	
	private List<RMData> rmData = new ArrayList<RMData>();
	
	public boolean isRmFilled() {
		return !rmData.isEmpty();
	}

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

	public List<RMData> getRmData() {
		return rmData;
	}

	public void setRmData(List<RMData> rmData) {
		this.rmData = rmData;
	}
}
