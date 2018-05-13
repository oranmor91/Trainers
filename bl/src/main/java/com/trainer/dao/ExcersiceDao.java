package com.trainer.dao;

import java.util.List;

import com.trainer.entity.ExcersiceEntity;

public interface ExcersiceDao {

	public ExcersiceEntity get(Integer id);
	
	public ExcersiceEntity save(ExcersiceEntity entity);
	
	public List<ExcersiceEntity> getAll();
	
	public void delete(Integer id);
}
