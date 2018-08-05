package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.trainer.dao.ProgramDao;
import com.trainer.dao.ProgramDefDao;
import com.trainer.dto.ExercisesData;
import com.trainer.dto.Program;
import com.trainer.dto.ProgramData;
import com.trainer.dto.ProgramDef;
import com.trainer.dto.WorkoutData;
import com.trainer.entity.ExerciseEntity;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.entity.ProgramEntity;
import com.trainer.entity.RMData;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.manaager.ProgramManager;
import com.trainer.manaager.UserManager;
import com.trainer.manaager.WorkoutManager;
import com.trainer.rm.RMCalculatorBuilder;
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
	private WorkoutManager m_workoutManager;
	
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
		filterDtosByCoach(programs, m_userManager);
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
		setCoachId(dto, m_userManager);
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
	
	
	@Override
	public void fillRmData(Program program) throws Exception {
		ProgramEntity programEntity = getEntity(program.getId());
		
		if (programEntity == null)
			throw new Exception("Failed to find program with id: " + program.getId());
		
		List<RMData> data = createRmDataFromProgram(program);
		
		programEntity = fillRmDataToEntity(data, programEntity);
		updateWeights(programEntity);
		saveEntity(programEntity);
	}
	
	private List<RMData> createRmDataFromProgram(Program program) {
		List<RMData> results = new ArrayList<RMData>();
		
		ProgramData data = program.getData();
		
		for (WorkoutData workout : data.getWorkouts()) {
			for (ExercisesData exercises : workout.getExercises()) {
				results.add(createRmData(workout.getId(), exercises.getExerciseWorkoutId(), exercises.getWeight()));
			}
		}
		
		return results;
	}

	private RMData createRmData(Integer workoutId, Integer exerciseWorkoutId, Integer data) {
		RMData result = new RMData();
		result.setData(data);
		result.setWorkoutId(workoutId);
		result.setExcersiceWorkout(exerciseWorkoutId);
		return result;
	}

	private void updateWeights(ProgramEntity programEntity) {
		ProgramData programData = programEntity.getData();
		Map<Integer, Map<Integer, ExercisesData>> workoutExcersiceMap = createWorkoutExcericeMap(programData);

		
		for (RMData rmData : programEntity.getRmData())
			calculateAndUpdateRmData(rmData, workoutExcersiceMap);
		
		programEntity.setData(programData);
	}

	private Map<Integer, Map<Integer, ExercisesData>> createWorkoutExcericeMap(ProgramData programData) {
		Map<Integer, Map<Integer, ExercisesData>> result = new HashMap<Integer, Map<Integer, ExercisesData>>();
		
		for (WorkoutData workout : programData.getWorkouts()) {
			Map<Integer, ExercisesData> excersiceById = result.get(workout.getId());
			
			if (excersiceById == null) {
				excersiceById = new HashMap<Integer, ExercisesData>();
				result.put(workout.getId(), excersiceById);
			}
			
			for (ExercisesData excersice : workout.getExercises())
				excersiceById.put(excersice.getId(), excersice);
		}

		return result;
	}

	private void calculateAndUpdateRmData(RMData rmData, Map<Integer, Map<Integer, ExercisesData>> workoutExcersiceMap) {
		Integer newWeight = RMCalculatorBuilder.instance(rmData).simpleRmCalculator().build();
		
		Map<Integer, ExercisesData> exversiceByIdMap = workoutExcersiceMap.get(rmData.getWorkoutId());

		if (exversiceByIdMap == null)
			throw new RuntimeException("Failed to find workout with id: " + rmData.getWorkoutId());
		
		ExerciseWorkoutEntity excersiceWorkoutEntity = m_workoutManager.getExcersiceWorkoutEntity(rmData.getExcersiceWorkout());
		ExercisesData excersiceData = exversiceByIdMap.get(excersiceWorkoutEntity.getExercise().getId());
		
		if (excersiceData == null)
			throw new RuntimeException("Failed to find excersice with id: " + rmData.getExcersiceWorkout());
		
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
		Set<WorkoutEntity> workouts = parentDef.getWorkouts();
		
		Integer numberOfEx = 0;
		
		for (Iterator<WorkoutEntity> iter = workouts.iterator(); iter.hasNext();) {
			WorkoutEntity next = iter.next();
			numberOfEx += next.getExcersices().size();
		}
		
		if (numberOfEx != rms.size())
			throw new Exception("Please fill all RM Data");
	}

	private void validateRm(RMData rm) throws Exception {
		if (rm.getData() == null || rm.getData() == 0)
			throw new Exception("No rm data was filled");
		
		if (rm.getExcersiceWorkout() == null)
			throw new Exception("No excersice was filled");
		
		if (rm.getWorkoutId() == null)
			throw new Exception("No workout was filled");
	}

	@Override
	public Program getMyCurrentProgram() {
		UserEntity byUniqueID = m_userManager.getUserEntityByUniqueID(getLoggedInUser());
		ProgramEntity programEntity = m_programDao.getLatestProgram(byUniqueID.getId());
		return ModelPersister.convert(programEntity, m_dtoVisitor);
	}
	
	@Override
	public Program getUserProgram(Integer id) {
		UserEntity user = m_userManager.getEntity(id);
		UserEntity coach = user.getCoach();
		
		if (!coach.getEmail().equals(getLoggedInUser()))
			return null;
		
		ProgramEntity programEntity = m_programDao.getLatestProgram(user.getId());
		return ModelPersister.convert(programEntity, m_dtoVisitor);
	}

	@Override
	public Program assignUserToProgram(Integer programId, UserEntity userEntity, UserEntity coachEntity) {
		ProgramDefEntity programDefEntity = getDefEntity(programId);
		ProgramEntity program = new ProgramEntity();
		program.setCoach(coachEntity);
		program.setName(programDefEntity.getName() + userEntity.getFirstName());
		program.setParentDef(programDefEntity);
		program.setStartDate(new Date());
		program.setTrainer(userEntity);
		program.setData(createData(programDefEntity));
		ProgramEntity saveEntity = saveEntity(program);
		return ModelPersister.convert(saveEntity, m_dtoVisitor);
	}

	private ProgramData createData(ProgramDefEntity programDefEntity) {
		ProgramData result = new ProgramData();
		
		for (WorkoutEntity workout : programDefEntity.getWorkouts())
			result.getWorkouts().add(toWorkoutData(workout));
		
		return result;
	}

	private WorkoutData toWorkoutData(WorkoutEntity workout) {
		WorkoutData result = new WorkoutData();
		result.setId(workout.getId());
		result.setName(workout.getName());
		
		for (ExerciseWorkoutEntity exercise : workout.getExcersices())
			result.getExercises().add(toExcersiceWorkoutData(exercise));
		
		return result;
	}

	private ExercisesData toExcersiceWorkoutData(ExerciseWorkoutEntity exerciseWorkout) {
		ExercisesData result = new ExercisesData();
		ExerciseEntity exercise = exerciseWorkout.getExercise();
		result.setId(exercise.getId());
		result.setName(exercise.getName());
		result.setComment(exercise.getComment());
		result.setPrimaryMuscle(exercise.getPrimaryMuscle());
		result.setVideoURL(exercise.getVideoURL());
		result.setExerciseWorkoutId(exerciseWorkout.getId());
		result.setNumOfIntervals(exerciseWorkout.getNumOfIntervals());
		result.setNumOfSets(exerciseWorkout.getNumOfSets());
		return result;
	}
}
