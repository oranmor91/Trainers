package com.trainer.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.trainer.visitors.BaseVisitor;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private UserEntity coach;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isPersistent(){
		return getId() != null;
	}
	
	public UserEntity getCoach() {
		return coach;
	}

	public void setCoach(UserEntity coach) {
		this.coach = coach;
	}
	
	public abstract Object accept(BaseVisitor visitor, Object... obj);

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null || !(obj instanceof BaseEntity))
			return false;
		
		BaseEntity other = (BaseEntity) obj;
		
		return other.id == this.id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
}
