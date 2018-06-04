package com.trainer.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.trainer.dto.PersonalProgramData;
import com.trainer.utils.JsonHelper;
import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="person_program")
public class PersonalProgramEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;
	
	@OneToOne
	private UserEntity trainer;
	
	@OneToOne
	private ProgramDefEntity parentDef;

	@Column
	private Date startDate;
	
	@Column
	@Lob
	private String personalData;
	
	@Transient
	private PersonalProgramData data;
	
	public PersonalProgramData getData()  {
		try {
			return JsonHelper.jsonToObject(personalData, PersonalProgramData.class);
		}catch (Exception e) {
		}
		
		return null;
	}

	public void setData(PersonalProgramData data) {
		this.data = data;
		
		try {
			personalData = JsonHelper.objectToJson(data);
		} catch (Exception e) {}
	}
	public Object accept(BaseVisitor visitor, Object... obj) {
		return visitor.visit(this, obj);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public UserEntity getTrainer() {
		return trainer;
	}


	public void setTrainer(UserEntity trainer) {
		this.trainer = trainer;
	}


	public ProgramDefEntity getParentDef() {
		return parentDef;
	}


	public void setParentDef(ProgramDefEntity parentDef) {
		this.parentDef = parentDef;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
