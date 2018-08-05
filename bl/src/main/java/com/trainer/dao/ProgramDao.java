package com.trainer.dao;

import com.trainer.entity.ProgramEntity;

public interface ProgramDao extends BaseDao<ProgramEntity>{

	public ProgramEntity getLatestProgram(Integer id);

}
