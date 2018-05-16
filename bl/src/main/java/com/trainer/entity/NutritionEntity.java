package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="nutrition")
public class NutritionEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	@Lob
	private Byte[] file;
	
	@Column
	private String name;

	@ManyToOne
	private TrainerEntity trainer;
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}
}
