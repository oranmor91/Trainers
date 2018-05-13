package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.Excersice;
import com.trainer.entity.ExcersiceEntity;

public interface ExcersiceManager {

	public Excersice get(Integer id);
	
	public List<Excersice> getAll();
	
	public List<ExcersiceEntity> getAllEntities();
	
	public ExcersiceEntity getEntity(Integer id);
	
	public Excersice save(Excersice dto);
	
	public ExcersiceEntity saveEntity(ExcersiceEntity entity);
	
	public void delete(Integer id);
}
