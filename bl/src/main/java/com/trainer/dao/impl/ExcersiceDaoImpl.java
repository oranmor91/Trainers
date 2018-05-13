package com.trainer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.trainer.dao.ExcersiceDao;
import com.trainer.entity.ExcersiceEntity;

@Repository
public class ExcersiceDaoImpl implements ExcersiceDao{

	@PersistenceContext
	private EntityManager m_entityManager;
	
	@Override
	public ExcersiceEntity get(Integer id) {
		return m_entityManager.find(ExcersiceEntity.class, id);
	}
	
	@Override
	public List<ExcersiceEntity> getAll() {
		TypedQuery<ExcersiceEntity> createQuery = m_entityManager.createQuery("FROM ExcersiceEntity", ExcersiceEntity.class);
		
		List<ExcersiceEntity> resultList = createQuery.getResultList();
		
		if (resultList == null)
			resultList = new ArrayList<ExcersiceEntity>();
		
		return resultList;
	}

	@Override
	@Transactional
	public ExcersiceEntity save(ExcersiceEntity entity) {
		if (entity == null)
			return null;
		
		ExcersiceEntity result;
		if (!entity.isPersistent()){
			m_entityManager.persist(entity);
			result = entity;
		}else{
			result = m_entityManager.merge(entity);
		}
		
		return result;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ExcersiceEntity user = get(id);
		
		if (user != null)
			m_entityManager.remove(user);
	}
}
