package com.trainer.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainer.dto.ExerciseWorkout;
import com.trainer.dto.Workout;
import com.trainer.manaager.WorkoutManager;

@Controller
@RequestMapping("/admin/workout")
public class WorkoutAdminController {

	@Autowired
	private WorkoutManager m_workoutManager;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Workout get(@PathVariable Integer id) {
		Workout workout = m_workoutManager.get(id);
		revertReplaceExcersiceIdWithId(workout);
		return workout;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Workout> getAll() {
		List<Workout> results = m_workoutManager.getAll();
		
		for (Workout result : results)
			revertReplaceExcersiceIdWithId(result);
		
		return results;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Workout save(@RequestBody Workout dto) {
		replaceExcersiceIdWithId(dto);
		Workout result = m_workoutManager.save(dto);
		revertReplaceExcersiceIdWithId(result);
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Integer id) throws Exception {
		m_workoutManager.delete(id);
	}
	
	private void replaceExcersiceIdWithId(Workout dto) {
		for (ExerciseWorkout excerise : dto.getExercise()) {
			excerise.setExcersiceId(excerise.getId());
			excerise.setId(null);
		}
	}
	
	private void revertReplaceExcersiceIdWithId(Workout workout) {
		for (ExerciseWorkout excerise : workout.getExercise()) {
			excerise.setId(excerise.getExcersiceId());
			excerise.setExcersiceId(null);
		}
	}
}
