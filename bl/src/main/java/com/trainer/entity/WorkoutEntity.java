package com.trainer.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="workout")
public class WorkoutEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "excersice_workout", joinColumns = { @JoinColumn(name = "workout_id") }, inverseJoinColumns = { @JoinColumn(name = "excersice_id") })
	private List<ExcersiceEntity> excersices = new ArrayList<ExcersiceEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExcersiceEntity> getExcersices() {
		return excersices;
	}

	public void setExcersices(List<ExcersiceEntity> excersices) {
		this.excersices = excersices;
	}


}
