package com.trainer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="excersice")
public class ExerciseEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@Column
	private String primaryMuscle;
	
	@Column
	private String comment;
	
	@Column
	private String videoURL;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryMuscle() {
		return primaryMuscle;
	}

	public void setPrimaryMuscle(String primaryMuscle) {
		this.primaryMuscle = primaryMuscle;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}
}
