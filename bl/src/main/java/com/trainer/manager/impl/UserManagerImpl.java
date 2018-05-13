package com.trainer.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.UserDao;
import com.trainer.dto.Trainer;
import com.trainer.entity.TrainerEntity;
import com.trainer.manaager.UserManager;

@Service
@Scope("singleton")
public class UserManagerImpl implements UserManager{

	@Autowired
	private UserDao m_userDao;
	
	@Override
	public Trainer getUser(Integer id) {
		TrainerEntity userEntity = m_userDao.get(id);
		
		if (userEntity == null)
			return null;
		
		Trainer result = new Trainer();
		result.setId(userEntity.getId());
		result.setFirstName(userEntity.getFirstName());
		result.setLastName(userEntity.getLastName());
		return result;
	}
}
