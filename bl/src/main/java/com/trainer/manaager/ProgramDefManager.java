package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.ProgramDef;
import com.trainer.entity.ProgramDefEntity;

public interface ProgramDefManager {

	public ProgramDef get(Integer id);
	
	public List<ProgramDef> getAll();
	
	public List<ProgramDefEntity> getAllEntities();
	
	public ProgramDefEntity getEntity(Integer id);
	
	public ProgramDef save(ProgramDef dto);
	
	public ProgramDefEntity saveEntity(ProgramDefEntity entity);
	
	public void delete(Integer id);
}
