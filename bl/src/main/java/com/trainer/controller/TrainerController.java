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

import com.trainer.dto.Trainer;
import com.trainer.manaager.TrainerManager;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerManager m_trainerManager;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Trainer get(@PathVariable Integer id) {
		return m_trainerManager.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Trainer> getAll() {
		return m_trainerManager.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Trainer save(@RequestBody Trainer dto) {
		return m_trainerManager.save(dto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		m_trainerManager.delete(id);
	}
}