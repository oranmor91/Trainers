package com.trainer.utils;

import java.util.ArrayList;
import java.util.List;

import com.trainer.dao.BaseDao;
import com.trainer.dto.BaseDto;
import com.trainer.entity.BaseEntity;
import com.trainer.visitors.BaseVisitor;

public class ModelPersister {

	public static <DTO extends BaseDto, ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> DTO get(Integer id, DAO dao, BaseVisitor vistor) {
		ENTITY entity = dao.get(id);
		return convert(entity, vistor);
	}

	public static <DTO extends BaseDto, ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> List<DTO> getAll(Integer coachId, DAO dao, BaseVisitor visitor) {
		List<DTO> results = new ArrayList<DTO>();
		
		for (ENTITY entity : dao.getAll(coachId)) 
			results.add(convert(entity, visitor));
		
		return results;
	}

	@SuppressWarnings("unchecked")
	public static <DTO extends BaseDto, ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> DTO save(DTO dto, Integer coachId, ENTITY newInstance, DAO dao, BaseVisitor m_dtoVisitor, BaseVisitor m_entityVistor) {
		dto.setCoachId(coachId);
		ENTITY entity = dto.getId() != null ? getEntity(dto.getId(), dao) : newInstance;
		
		entity = (ENTITY) entity.accept(m_entityVistor, dto);
		entity = dao.save(entity);
		
		return convert(entity, m_dtoVisitor);
	}

	public static <ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> List<ENTITY> getAllEntities(Integer coachId, DAO dao) {
		return dao.getAll(coachId);
	}

	public static <ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> ENTITY getEntity(Integer id, DAO dao) {
		return dao.get(id);
	}
	
	public static <ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> ENTITY saveEntity(ENTITY entity, DAO dao) {
		return dao.save(entity);
	}
	
	public static <ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>> void delete(Integer id, DAO dao) {
		dao.delete(id);
	}
	
	@SuppressWarnings("unchecked")
	public static <ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>, DTO extends BaseDto> DTO convert(ENTITY entity, 
																												 BaseVisitor dtoConverter,
																												 Object ... args) {
		if (entity == null)
			return null;
		
		return (DTO) entity.accept(dtoConverter, args);
	}
	
	public static <ENTITY extends BaseEntity, DAO extends BaseDao<ENTITY>, DTO extends BaseDto> List<DTO> convertAll(List<ENTITY> entities, 
																												 BaseVisitor dtoConverter,
																												 Object ... args) {
		List<DTO> results = new ArrayList<DTO>();
		
		for (ENTITY entity : entities)
			results.add(convert(entity, dtoConverter, args));
		
		return results;
		
	}
}
