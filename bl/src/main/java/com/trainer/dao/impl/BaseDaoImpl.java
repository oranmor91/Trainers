package com.trainer.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.trainer.dao.BaseDao;
import com.trainer.entity.BaseEntity;

public class BaseDaoImpl<ENTITY extends BaseEntity> implements BaseDao<ENTITY>{

	@PersistenceContext
	protected EntityManager m_entityManager;
	
	@Override
	public ENTITY get(Integer id) {
		return m_entityManager.find(getEntityClass(), id);
	}

	@Override
	@Transactional
	public List<ENTITY> getAll() {
		String sql = "SELECT e FROM " + getEntityClass().getName() + " e";
		TypedQuery<ENTITY> createQuery = m_entityManager.createQuery(sql, getEntityClass());
		
		List<ENTITY> resultList = createQuery.getResultList();
		
		if (resultList == null)
			resultList = new ArrayList<ENTITY>();
		
		return resultList;
	}

	@Override
	@Transactional
	public ENTITY save(ENTITY entity) {
		ENTITY result = null;
		
		if (!entity.isPersistent()) {
			m_entityManager.persist(entity);
			result = entity;
		} else {
			result = m_entityManager.merge(entity);
		}
		
		return result;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ENTITY trainerEntity = get(id);
		
		if (trainerEntity != null)
			m_entityManager.remove(trainerEntity);		
	}

	@SuppressWarnings("unchecked")
	protected Class<ENTITY> getEntityClass() {
		return (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
