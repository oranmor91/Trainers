package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.User;
import com.trainer.entity.UserEntity;

public interface UserManager {

	public User get(Integer id);
	
	public List<User> getAll();
	
	public List<UserEntity> getAllEntities();
	
	public UserEntity getEntity(Integer id);
	
	public User save(User dto);
	
	public UserEntity saveEntity(UserEntity entity);
	
	public void delete(Integer id);

	public UserEntity getByUniqueID(String loggedInUser);
	
	public UserEntity getMyCoach();
	
	public Integer getMyCoachId();
	
}
