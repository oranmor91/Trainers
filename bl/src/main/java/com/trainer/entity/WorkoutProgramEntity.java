package com.trainer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="work_prog")
public class WorkoutProgramEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "workout_program_links", joinColumns = { @JoinColumn(name = "work_prog_id") }, inverseJoinColumns = { @JoinColumn(name = "workout_id")})
	private List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorkoutEntity> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutEntity> workouts) {
		this.workouts = workouts;
	}

}
