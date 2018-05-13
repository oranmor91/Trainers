package com.trainer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="workout")
public class WorkoutEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	private List<ExcersiceWorkoutEntity> excersices = new ArrayList<ExcersiceWorkoutEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
