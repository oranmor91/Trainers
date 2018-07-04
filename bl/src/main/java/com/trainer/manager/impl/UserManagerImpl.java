package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.UserDao;
import com.trainer.dto.User;
import com.trainer.entity.UserEntity;
import com.trainer.manaager.UserManager;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class UserManagerImpl extends BaseManager implements UserManager{

	@Autowired
	private UserDao m_trainerDao;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public List<UserEntity> getAllEntities() {
		return ModelPersister.getAllEntities(getLoggedInUser(), m_trainerDao);
	}

	@Override
	public UserEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_trainerDao);
	}
	
	@Override
	@Transactional
	public UserEntity saveEntity(UserEntity entity) {
		return ModelPersister.saveEntity(entity, m_trainerDao);
	}

	@Override
	public User get(Integer id) {
		return ModelPersister.get(id, m_trainerDao, m_dtoVisitor);
	}

	@Override
	public List<User> getAll() {
		return ModelPersister.getAll(getLoggedInUser(), m_trainerDao, m_dtoVisitor);
	}

	@Override
	@Transactional
	public User save(User dto) {
		return ModelPersister.save(dto, getLoggedInUser(), new UserEntity(), m_trainerDao, m_dtoVisitor, m_entityVistor);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		ModelPersister.delete(id, m_trainerDao);
	}

	@Override
	public UserEntity getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
