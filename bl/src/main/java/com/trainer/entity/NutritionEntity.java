package com.trainer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nutrition")
public class NutritionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	@Lob
	private Byte[] file;
	
	@Column
	private String name;

	@ManyToOne
	private TrainerEntity trainer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
