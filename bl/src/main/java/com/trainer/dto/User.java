package com.trainer.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trainer.types.GenderType;
import com.trainer.utils.UserType;

public class User extends BaseDto{

	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	private GenderType gender;
	
	private Date BirthDay;
	
	private String phoneNumber;
	
	private String address;
	
	private Double height;
	
	private Double weight;
	
	private String email;
	
	private int numOfExperience;
	
	private List<Integer> nutritionId = new ArrayList<Integer>();
	
	@JsonIgnore
	private Set<UserType> roles = new HashSet<UserType>();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getNumOfExperience() {
		return numOfExperience;
	}

	public void setNumOfExperience(int numOfExperience) {
		this.numOfExperience = numOfExperience;
	}

	public List<Integer> getNutritionId() {
		return nutritionId;
	}

	public void setNutritionId(List<Integer> nutritionId) {
		this.nutritionId = nutritionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserType> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserType> roles) {
		this.roles = roles;
	}

	public UserType getType() {
		if (roles.contains(UserType.COACH))
			return UserType.COACH;
		else
			return UserType.TRAINER;
	}
}
