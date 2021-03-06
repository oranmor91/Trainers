package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.Program;
import com.trainer.dto.User;
import com.trainer.entity.UserEntity;

public interface UserManager {

	public User get(Integer id);
	
	public List<User> getAll();
	
	public List<UserEntity> getAllEntities();
	
	public UserEntity getEntity(Integer id);
	
	public UserEntity saveEntity(UserEntity entity);
	
	public void delete(Integer id);

	public UserEntity getUserEntityByUniqueID(String loggedInUser);
	
	public UserEntity getMyCoach();

	public User saveUser(User dto);

	public User saveAdmin(User dto);

	public User getUserByUniqueID(String email);

	public Program assignUserToProgram(Integer userId, Integer programId);

	public User getMySelf();
}
