package com.trainer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="work_prog")
public class WorkoutProgramEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String notes;
	
	@ManyToMany(cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name = "workout_program_link", joinColumns = { @JoinColumn(name = "work_prog_id") }, inverseJoinColumns = { @JoinColumn(name = "workouts_id") })
	private List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}

	public List<WorkoutEntity> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutEntity> workouts) {
		this.workouts = workouts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
