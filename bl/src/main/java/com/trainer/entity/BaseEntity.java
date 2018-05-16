package com.trainer.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.trainer.visitors.BaseVisitor;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isPersistent(){
		return getId() != null;
	}
	
	public abstract Object accept(BaseVisitor visitor, Object... obj);
}
