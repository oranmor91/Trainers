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
	private UserEntity user;
	
	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}
}
