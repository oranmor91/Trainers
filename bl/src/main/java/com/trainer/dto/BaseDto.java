package com.trainer.dto;

import java.io.Serializable;

public abstract class BaseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer coachId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	
}
