package com.trainer.utils;

import com.trainer.dao.BaseDao;
import com.trainer.dto.BaseDto;
import com.trainer.entity.BaseEntity;
import com.trainer.visitors.BaseVisitor;

public class ModelPersister {

	@SuppressWarnings("unchecked")
	public static <DTO extends BaseDto, ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> DTO get(Integer id, DAO dao, BaseVisitor vistor) {
		ENTITY entity = dao.get(id);
		return entity == null ? null : (DTO) entity.accept(vistor); 
	}
	
}
