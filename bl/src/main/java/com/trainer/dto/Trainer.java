package com.trainer.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.trainer.types.GenderType;

public class Trainer extends BaseDto{

	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	private GenderType gender;
	
	private Date BirthDay;
	
	private String phoneNumber;
	
	private String adress;
	
	private Double height;
	
	private Double weight;
	
	private int numOfExpeirence;
	
	private List<Integer> nutritionId = new ArrayList<Integer>();

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

	public List<Integer> getNutritionId() {
		return nutritionId;
	}

	public void setNutritionId(List<Integer> nutritionId) {
		this.nutritionId = nutritionId;
	}
}
