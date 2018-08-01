package com.trainer.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ProgramDao;
import com.trainer.dao.ProgramDefDao;
import com.trainer.dto.ExcersiceData;
import com.trainer.dto.Program;
import com.trainer.dto.ProgramData;
import com.trainer.dto.ProgramDef;
import com.trainer.dto.WorkoutData;
import com.trainer.entity.ExcersiceWorkoutEntity;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.entity.ProgramEntity;
import com.trainer.entity.RMData;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ProgramManager;
import com.trainer.manaager.UserManager;
import com.trainer.rm.RMCalculatorBuilder;
import com.trainer.utils.FilterUtils;
import com.trainer.utils.ModelPersister;
import com.trainer.visitors.BaseVisitor;

@Service
@Scope("singleton")
public class ProgramManagerImpl extends BaseManager implements ProgramManager{

	@Autowired
	private ProgramDefDao m_programDefDao;
	
	@Autowired
	private ProgramDao m_programDao;
	
	@Autowired
	private UserManager m_userManager;
	
	@Autowired
	@Qualifier("DtoVisitor")
	private BaseVisitor m_dtoVisitor;
	
	@Autowired
	@Qualifier("EntityVisitor")
	private BaseVisitor m_entityVistor;
	
	@Override
	public ProgramDef getDef(Integer id) {
		return ModelPersister.get(id, m_programDefDao, m_dtoVisitor);
	}
	
	@Override
	public List<ProgramDef> getAllDef() {
		List<ProgramDef> programs = ModelPersister.getAll(m_programDefDao, m_dtoVisitor);
		UserEntity caoch = m_userManager.getUserEntityByUniqueID(getLoggedInUser());
		FilterUtils.filter(programs, caoch.getId());
		return programs;
	}

	@Override
	public List<ProgramDefEntity> getAllDefEntities() {
		return ModelPersister.getAllEntities(m_programDefDao);
	}
	
	@Override
	public ProgramDefEntity getDefEntity(Integer id) {
		return ModelPersister.getEntity(id, m_programDefDao);
	}

	@Override
	@Transactional
	public ProgramDef saveDef(ProgramDef dto) {
		return ModelPersister.save(dto, new ProgramDefEntity(), m_programDefDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	@Transactional
	public ProgramDefEntity saveDefEntity(ProgramDefEntity entity) {
		return ModelPersister.saveEntity(entity, m_programDefDao);
	}

	@Override
	@Transactional
	public void deleteDef(Integer id) {
		ModelPersister.delete(id, m_programDefDao);
	}
	
	@Override
	public Program get(Integer id) {
		return ModelPersister.get(id, m_programDao, m_dtoVisitor);
	}
	
	@Override
	public List<Program> getAll() {
		return ModelPersister.getAll(m_programDao, m_dtoVisitor);
	}

	@Override
	public List<ProgramEntity> getAllEntities() {
		return ModelPersister.getAllEntities(m_programDao);
	}
	
	@Override
	public ProgramEntity getEntity(Integer id) {
		return ModelPersister.getEntity(id, m_programDao);
	}

	@Override
	@Transactional
	public Program saveDef(Program dto) {
		return ModelPersister.save(dto, new ProgramEntity(), m_programDao, m_dtoVisitor, m_entityVistor);
	}

	@Override
	@Transactional
	public ProgramEntity saveEntity(ProgramEntity entity) {
		return ModelPersister.saveEntity(entity, m_programDao);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ModelPersister.delete(id, m_programDao);
	}
	
	public void fillRmData(List<RMData> data, Integer programId) throws Exception{
		ProgramEntity programEntity = getEntity(programId);
		
		if (programEntity == null)
			throw new Exception("Failed to find program with id: " + programId);
		
		programEntity = fillRmDataToEntity(data, programEntity);
		updateWeights(programEntity);
		saveEntity(programEntity);
	}

	private void updateWeights(ProgramEntity programEntity) {
		ProgramData programData = programEntity.getData();
		Map<Integer, Map<Integer, ExcersiceData>> workoutExcersiceMap = createWorkoutExcericeMap(programData);

		
		for (RMData rmData : programEntity.getRmData())
			calculateAndUpdateRmData(rmData, workoutExcersiceMap);
	}

	private Map<Integer, Map<Integer, ExcersiceData>> createWorkoutExcericeMap(ProgramData programData) {
		Map<Integer, Map<Integer, ExcersiceData>> result = new HashMap<Integer, Map<Integer, ExcersiceData>>();
		
		for (WorkoutData workout : programData.getWorkouts()) {
			Map<Integer, ExcersiceData> excersiceById = result.get(workout.getId());
			
			if (excersiceById == null) {
				excersiceById = new HashMap<Integer, ExcersiceData>();
				result.put(workout.getId(), excersiceById);
			}
			
			for (ExcersiceData excersice : workout.getExcersices())
				excersiceById.put(excersice.getId(), excersice);
		}

		return result;
	}

	private void calculateAndUpdateRmData(RMData rmData, Map<Integer, Map<Integer, ExcersiceData>> workoutExcersiceMap) {
		Integer newWeight = RMCalculatorBuilder.instance(rmData).simpleRmCalculator().build();
		
		WorkoutEntity workout = rmData.getWorkout();
		Map<Integer, ExcersiceData> exversiceByIdMap = workoutExcersiceMap.get(workout.getId());

		if (exversiceByIdMap == null)
			throw new RuntimeException("Failed to find workout with id: " + workout.getId());
		
		ExcersiceWorkoutEntity excersice = rmData.getExcersice();
		ExcersiceData excersiceData = exversiceByIdMap.get(excersice.getId());
		
		if (excersiceData == null)
			throw new RuntimeException("Failed to find excersice with id: " + excersice.getId());
		
		excersiceData.setWeight(newWeight);
	}

	private ProgramEntity fillRmDataToEntity(List<RMData> rms, ProgramEntity programEntity) throws Exception {
		ProgramDefEntity parentDef = programEntity.getParentDef();
		
		if (parentDef == null)
			throw new RuntimeException("Failed to find parent for program with id:" + programEntity.getId());
	
		validateProgramData(rms, parentDef);
		programEntity.getRmData().clear();
		programEntity.getRmData().addAll(rms);
		return programEntity;
	}

	private void validateProgramData(List<RMData> rms, ProgramDefEntity parentDef) throws Exception {
		validateAllRMDataWasFilled(rms, parentDef);
		
		for (RMData rm : rms)
			validateRm(rm);
	}

	private void validateAllRMDataWasFilled(List<RMData> rms, ProgramDefEntity parentDef) throws Exception {
		List<WorkoutEntity> workouts = parentDef.getWorkouts();
		
		if (workouts.size() != rms.size())
			throw new Exception("Please fill all RM Data");
	}

	private void validateRm(RMData rm) throws Exception {
		if (rm.getData() == null || rm.getData() == 0)
			throw new Exception("No rm data was filled");
		
		if (rm.getExcersice() == null)
			throw new Exception("No excersice was filled");
		
		if (rm.getWorkout() == null)
			throw new Exception("No workout was filled");
	}

	@Override
	public Program getMyCurrentProgram() {
		UserEntity byUniqueID = m_userManager.getUserEntityByUniqueID(getLoggedInUser());
		return ModelPersister.get(byUniqueID.getId(), m_programDao, m_dtoVisitor);
	}
}
