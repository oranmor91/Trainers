package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="wrk_prog_link")
public class WorkoutProgramLinkEntity {

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
}
