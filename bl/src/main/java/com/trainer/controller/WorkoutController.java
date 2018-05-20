package com.trainer.controller;

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

import com.trainer.dto.Workout;
import com.trainer.manaager.WorkoutManager;

@Controller
@RequestMapping("/workout")
public class WorkoutController {

	@Autowired
	private WorkoutManager m_workoutManager;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Workout get(@PathVariable Integer id) {
		return m_workoutManager.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Workout> getAll() {
		return m_workoutManager.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Workout save(@RequestBody Workout dto) {
		return m_workoutManager.save(dto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		m_workoutManager.delete(id);
	}
}
