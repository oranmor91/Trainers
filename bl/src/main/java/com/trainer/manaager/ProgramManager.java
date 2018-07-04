package com.trainer.manaager;

import java.util.List;

import com.trainer.dto.Program;
import com.trainer.dto.ProgramDef;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.entity.ProgramEntity;

public interface ProgramManager {

	public ProgramDef getDef(Integer id);
	
	public List<ProgramDef> getAllDef();
	
	public List<ProgramDefEntity> getAllDefEntities();
	
	public ProgramDefEntity getDefEntity(Integer id);
	
	public ProgramDef saveDef(ProgramDef dto);
	
	public ProgramDefEntity saveDefEntity(ProgramDefEntity entity);
	
	public void deleteDef(Integer id);

	public Program get(Integer id);

	public List<Program> getAll();

	public List<ProgramEntity> getAllEntities();

	public ProgramEntity getEntity(Integer id);

	public Program saveDef(Program dto);

	public ProgramEntity saveEntity(ProgramEntity entity);

	public void delete(Integer id);
}
