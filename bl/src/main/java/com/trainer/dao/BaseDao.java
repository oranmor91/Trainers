package com.trainer.dao;

import java.util.List;

import com.trainer.entity.BaseEntity;

public interface BaseDao<ENTITY extends BaseEntity> {

	public ENTITY get(Integer id);
	
	public List<ENTITY> getAll();
	
	public ENTITY save(ENTITY entity);
	
	public void delete(Integer id);
}
