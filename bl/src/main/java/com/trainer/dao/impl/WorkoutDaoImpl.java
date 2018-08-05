package com.trainer.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.trainer.dao.WorkoutDao;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.WorkoutEntity;

@Repository
public class WorkoutDaoImpl extends BaseDaoImpl<WorkoutEntity> implements WorkoutDao{

	@Override
	public ExerciseWorkoutEntity getExcersiceWorkoutEntity(Integer id) {
		TypedQuery<ExerciseWorkoutEntity> query = m_entityManager.createQuery("SELECT ew FROM ExcersiceWorkoutEntity ew where ew.id = :id", ExerciseWorkoutEntity.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

}
