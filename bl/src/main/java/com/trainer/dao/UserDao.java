package com.trainer.dao;

import com.trainer.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity>{

	public UserEntity findByEmail(String email);
}
