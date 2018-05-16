package com.trainer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wrk_prog_link")
public class WorkoutProgramLinkEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private WorkoutEntity workout;
	
	@ManyToOne
	private WorkoutProgramEntity program;
	
	@Column
	private Integer programOrder;

	public WorkoutEntity getWorkout() {
		return workout;
	}

	public void setWorkout(WorkoutEntity workout) {
		this.workout = workout;
	}

	public WorkoutProgramEntity getProgram() {
		return program;
	}

	public void setProgram(WorkoutProgramEntity program) {
		this.program = program;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
