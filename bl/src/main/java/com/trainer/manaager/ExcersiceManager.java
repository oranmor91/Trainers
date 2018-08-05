package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.Excersice;
import com.trainer.entity.ExerciseEntity;

public interface ExcersiceManager {

	public Excersice get(Integer id);
	
	public List<Excersice> getAll();
	
	public List<ExerciseEntity> getAllEntities();
	
	public ExerciseEntity getEntity(Integer id);
	
	public Excersice save(Excersice dto);
	
	public ExerciseEntity saveEntity(ExerciseEntity entity);
	
	public void delete(Integer id) throws Exception;
}
