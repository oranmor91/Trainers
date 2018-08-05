package com.trainer.manager.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.UserDao;
import com.trainer.dto.Program;
import com.trainer.dto.User;
import com.trainer.entity.UserEntity;
import com.trainer.manaager.ProgramManager;
import com.trainer.manaager.UserManager;
import com.trainer.utils.ModelPersister;
import com.trainer.utils.UserType;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class UserManagerImpl extends BaseManager implements UserManager{

	@Autowired
	private UserDao m_trainerDao;
	
	@Autowired
	private UserManager m_userManager;
	
	@Autowired
	private ProgramManager m_programManager;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public List<UserEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_trainerDao);
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
		List<User> users = ModelPersister.getAll(m_trainerDao, m_dtoVisitor);
		filterDtosByCoach(users, m_userManager);
		return users;
	}

	@Override
	@Transactional
	public User saveUser(User dto) {
		setCoachId(dto, this);
		return save(dto);
	}
	
	@Override
	@Transactional
	public User saveAdmin(User dto) {
		dto.getRoles().clear();
		dto.getRoles().add(UserType.COACH);
		return save(dto);
	}
	
	private User save(User dto) {
		return ModelPersister.save(dto, new UserEntity(), m_trainerDao, m_dtoVisitor, m_entityVistor);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		ModelPersister.delete(id, m_trainerDao);
	}

	@Override
	public UserEntity getUserEntityByUniqueID(String email) {
		return email == null ? null : m_trainerDao.findByEmail(email);
	}
	
	@Override
	public User getUserByUniqueID(String email) {
		UserEntity userEntityByUniqueID = getUserEntityByUniqueID(email);
		return ModelPersister.convert(userEntityByUniqueID, m_dtoVisitor);
	}

	@Override
	public UserEntity getMyCoach() {
		return getUserEntityByUniqueID(getLoggedInUser());
	}
	
	@Override
	public Program assignUserToProgram(Integer userId, Integer programId) {
		return m_programManager.assignUserToProgram(programId, getEntity(userId), getUserEntityByUniqueID(getLoggedInUser()));
	}

	@Override
	public User getMySelf() {
		return getUserByUniqueID(getLoggedInUser());
	}
}
