package com.trainer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="workout")
public class WorkoutEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ExcersiceWorkoutEntity> excersices = new ArrayList<ExcersiceWorkoutEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}

	public List<ExcersiceWorkoutEntity> getExcersices() {
		return excersices;
	}

	public void setExcersices(List<ExcersiceWorkoutEntity> excersices) {
		this.excersices = excersices;
	}
}
