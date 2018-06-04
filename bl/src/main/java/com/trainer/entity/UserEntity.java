package com.trainer.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.trainer.types.GenderType;
import com.trainer.utils.UserType;
import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="user_roles")
	@Column(name="roles", length=4000)
	@Enumerated(EnumType.STRING)
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

	@Override
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}

	public Set<UserType> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserType> roles) {
		this.roles = roles;
	}
}
