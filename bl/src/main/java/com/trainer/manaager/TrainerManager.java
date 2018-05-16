package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.Trainer;
import com.trainer.entity.TrainerEntity;

public interface TrainerManager {

	public Trainer get(Integer id);
	
	public List<Trainer> getAll();
	
	public List<TrainerEntity> getAllEntities();
	
	public TrainerEntity getEntity(Integer id);
	
	public Trainer save(Trainer dto);
	
	public TrainerEntity saveEntity(TrainerEntity entity);
	
	public void delete(Integer id);
}
