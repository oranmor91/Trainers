package com.trainer.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainer.dao.UserDao;
import com.trainer.entity.UserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao{
}
