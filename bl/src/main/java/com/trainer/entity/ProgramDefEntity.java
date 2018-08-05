package com.trainer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="prog_def")
public class ProgramDefEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String notes;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "workout_prog_def", joinColumns = { @JoinColumn(name = "prog_def_id") }, inverseJoinColumns = { @JoinColumn(name = "workouts_id") })
	private Set<WorkoutEntity> workouts = new HashSet<WorkoutEntity>();
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}

	public Set<WorkoutEntity> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<WorkoutEntity> workouts) {
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
