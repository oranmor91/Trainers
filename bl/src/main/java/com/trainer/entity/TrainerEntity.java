package com.trainer.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trainer.types.GenderType;

@Entity
@Table(name="trainers")
public class TrainerEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	
	@Column
	private Date BirthDay;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String adress;
	
	@Column
	private Double height;
	
	@Column
	private Double weight;
	
	@Column 
	private int numOfExpeirence;
	
	@OneToMany(mappedBy="trainer", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private List<NutritionEntity> nutrions = new ArrayList<NutritionEntity>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getNumOfExpeirence() {
		return numOfExpeirence;
	}

	public void setNumOfExpeirence(int numOfExpeirence) {
		this.numOfExpeirence = numOfExpeirence;
	}

	public List<NutritionEntity> getNutrions() {
		return nutrions;
	}

	public void setNutrions(List<NutritionEntity> nutrions) {
		this.nutrions = nutrions;
	}
}
