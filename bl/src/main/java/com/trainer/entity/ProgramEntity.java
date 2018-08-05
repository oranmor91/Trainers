package com.trainer.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.trainer.dto.ProgramData;
import com.trainer.utils.JsonHelper;
import com.trainer.visitors.BaseVisitor;

@Entity
@Table(name="person_program")
public class ProgramEntity extends BaseEntity{

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
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="rm_data", joinColumns=@JoinColumn(name="person_program_id"), uniqueConstraints=@UniqueConstraint(columnNames = { "person_program_id", "workout", "excersiceWorkout" }))
	private List<RMData> rmData = new ArrayList<RMData>();
	
	@Transient
	private ProgramData data;
	
	@PostLoad
	private void init() {
		rmData.size();
	}
	
	
	public ProgramData getData()  {
		try {
			return JsonHelper.jsonToObject(personalData, ProgramData.class);
		}catch (Exception e) {
		}
		
		return null;
	}

	public void setData(ProgramData data) {
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

	public List<RMData> getRmData() {
		return rmData;
	}

	public void setRmData(List<RMData> rmData) {
		this.rmData = rmData;
	}
}
