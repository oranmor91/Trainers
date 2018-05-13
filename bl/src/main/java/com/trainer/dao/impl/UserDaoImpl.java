package com.trainer.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.trainer.dao.UserDao;
import com.trainer.entity.TrainerEntity;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager m_entityManager;
	
	@Override
	public TrainerEntity get(Integer id) {
		return m_entityManager.find(TrainerEntity.class, id);
	}
	
}
