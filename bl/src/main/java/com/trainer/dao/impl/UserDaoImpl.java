package com.trainer.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.trainer.dao.UserDao;
import com.trainer.entity.UserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao{

	@Override
	public UserEntity findByEmail(String email) {
		TypedQuery<UserEntity> query = m_entityManager.createNamedQuery("SELECT * FROM UserEntity u WHERE u.email = :email", UserEntity.class);
		query.setParameter("email", email);
		
		return query.getSingleResult();
	}
}
