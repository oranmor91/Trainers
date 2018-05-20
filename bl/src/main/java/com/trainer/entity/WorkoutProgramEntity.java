package com.trainer.entity;

import javax.persistence.Column;

import com.trainer.visitors.BaseVisitor;

public class WorkoutProgramEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String notes;
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}

}
