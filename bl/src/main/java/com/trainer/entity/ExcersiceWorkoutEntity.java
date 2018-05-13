package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ex_work")
public class ExcersiceWorkoutEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@OneToOne
	private ExcersiceEntity excersice;
	
	@Column
	private Integer numOfSets; 
	
	@Column
	private Integer numOfIntervals;

	public ExcersiceEntity getExcersice() {
		return excersice;
	}

	public void setExcersice(ExcersiceEntity excersice) {
		this.excersice = excersice;
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
