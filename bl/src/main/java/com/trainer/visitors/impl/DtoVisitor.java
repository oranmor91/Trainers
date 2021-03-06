package com.trainer.visitors.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trainer.dto.Excersice;
import com.trainer.dto.ExerciseWorkout;
import com.trainer.dto.Program;
import com.trainer.dto.ProgramDef;
import com.trainer.dto.User;
import com.trainer.dto.Workout;
import com.trainer.entity.ExerciseEntity;
import com.trainer.entity.ExerciseWorkoutEntity;
import com.trainer.entity.NutritionEntity;
import com.trainer.entity.ProgramDefEntity;
import com.trainer.entity.ProgramEntity;
import com.trainer.entity.UserEntity;
import com.trainer.entity.WorkoutEntity;
import com.trainer.visitors.BaseVisitor;

@Component
@Qualifier("DtoVisitor")
public class DtoVisitor implements BaseVisitor{

	@Override
	public Object visit(UserEntity entity, Object... obj) {
		User dto = new User();
		dto.setAddress(entity.getAddress());
		dto.setBirthDay(entity.getBirthDay());
		dto.setFirstName(entity.getFirstName());
		dto.setGender(entity.getGender());
		dto.setHeight(entity.getHeight());
		dto.setId(entity.getId());
		dto.setLastName(entity.getLastName());
		dto.setNumOfExperience(entity.getNumOfExperience());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setWeight(entity.getWeight());
		dto.setEmail(entity.getEmail());
		
		UserEntity coach = entity.getCoach();
		
		if (coach != null)
			dto.setCoachId(coach.getId());
		
		
		dto.getRoles().clear();
		dto.getRoles().addAll(entity.getRoles());
		return dto;
	}

	@Override
	public Object visit(ExerciseEntity entity, Object... obj) {
		Excersice dto = new Excersice();
		dto.setId(entity.getId());
		dto.setComment(entity.getComment());
		dto.setName(entity.getName());
		dto.setPrimaryMuscle(entity.getPrimaryMuscle());
		dto.setVideoURL(entity.getVideoURL());
		dto.setCoachId(entity.getCoach().getId());
		return dto;
	}

	@Override
	public Object visit(ExerciseWorkoutEntity excersiceWorkoutEntity, Object... obj) {
		ExerciseWorkout workoutExcersice = new ExerciseWorkout();
		workoutExcersice.setId(excersiceWorkoutEntity.getId());
		workoutExcersice.setExcersiceId(excersiceWorkoutEntity.getExercise().getId());
		workoutExcersice.setNumOfIntervals(excersiceWorkoutEntity.getNumOfIntervals());
		workoutExcersice.setNumOfSets(excersiceWorkoutEntity.getNumOfSets());
		
		UserEntity coach = excersiceWorkoutEntity.getCoach();
		
		if (coach != null)
			workoutExcersice.setCoachId(coach.getId());
		
		return workoutExcersice;
	}

	@Override
	public Object visit(NutritionEntity nutritionEntity, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WorkoutEntity workoutEntity, Object... obj) {
		Workout dto = new Workout();
		dto.setId(workoutEntity.getId());
		dto.setName(workoutEntity.getName());
		
		UserEntity coach = workoutEntity.getCoach();
		
		if (coach != null)
			dto.setCoachId(coach.getId());
		
		for (ExerciseWorkoutEntity excersice : workoutEntity.getExcersices()) {
			ExerciseWorkout workoutExcersice = (ExerciseWorkout) excersice.accept(this, excersice);
			dto.getExercise().add(workoutExcersice);
		}
		
		return dto;
	}

	@Override
	public Object visit(ProgramDefEntity programDefEntity, Object... obj) {
		ProgramDef dto = new ProgramDef();
		dto.setId(programDefEntity.getId());
		dto.setName(programDefEntity.getName());
		dto.setNotes(programDefEntity.getNotes());
		dto.setDescription(programDefEntity.getDescription());
		
		UserEntity coach = programDefEntity.getCoach();
		
		if (coach != null)
			dto.setCoachId(coach.getId());
		
		for (WorkoutEntity workout : programDefEntity.getWorkouts())
			dto.getWorkouts().add(workout.getId());
		
		return dto;
	}

	@Override
	public Program visit(ProgramEntity personalProgramEntity, Object... obj) {
		Program dto = new Program();
		dto.setId(personalProgramEntity.getId());
		dto.setName(personalProgramEntity.getName());
		dto.setStartDate(personalProgramEntity.getStartDate());
		
		UserEntity coach = personalProgramEntity.getCoach();
		dto.setCoachId(coach.getId());
		
		UserEntity trainer = personalProgramEntity.getTrainer();
		dto.setTrainerId(trainer.getId());
		
		ProgramDefEntity parentDef = personalProgramEntity.getParentDef();
		dto.setNotes(parentDef.getNotes());
		dto.setDescription(parentDef.getDescription());
		dto.setProgramDefId(parentDef.getId());
		dto.setData(personalProgramEntity.getData());
		dto.setRmFilled(!personalProgramEntity.getRmData().isEmpty());
		return dto;
	}
}
