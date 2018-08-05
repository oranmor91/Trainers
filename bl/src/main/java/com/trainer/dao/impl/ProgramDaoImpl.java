package com.trainer.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.trainer.dao.ProgramDao;
import com.trainer.entity.ProgramEntity;

@Repository
public class ProgramDaoImpl extends BaseDaoImpl<ProgramEntity> implements ProgramDao{

	@Override
	public ProgramEntity getLatestProgram(Integer userId) {
		Query query = m_entityManager.createNativeQuery("SELECT * FROM person_program p WHERE p.trainer_id = :userId order by p.startDate desc LIMIT 1", ProgramEntity.class);
		query.setParameter("userId", userId);
		
		List<?> resultList = query.getResultList();
		
		if (resultList == null || resultList.isEmpty())
			return null;
			
		return (ProgramEntity) resultList.iterator().next();
	}
}
