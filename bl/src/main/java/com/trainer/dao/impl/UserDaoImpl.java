package com.trainer.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.trainer.dao.UserDao;
import com.trainer.entity.UserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao{

	@Override
	public UserEntity findByEmail(String email) {
		TypedQuery<UserEntity> query = m_entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.email = :email", UserEntity.class);
		query.setParameter("email", email);
		
		List<UserEntity> resultList = query.getResultList();
		
		if (resultList == null || resultList.isEmpty())
			return null;
		
		return resultList.iterator().next();
	}
}
