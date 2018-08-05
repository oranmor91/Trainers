package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="ex_work")
public class ExerciseWorkoutEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@OneToOne
	private ExerciseEntity exercise;
	
	@Column
	private Integer numOfSets; 
	
	@Column
	private Integer numOfIntervals;
	
	public ExerciseEntity getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseEntity exercise) {
		this.exercise = exercise;
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
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}
}
