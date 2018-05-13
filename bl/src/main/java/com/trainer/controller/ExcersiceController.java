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

import com.trainer.dto.Excersice;
import com.trainer.manaager.ExcersiceManager;

@Controller
@RequestMapping("/excersice")
public class ExcersiceController {

	@Autowired
	private ExcersiceManager m_excersiceManager;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Excersice get(@PathVariable Integer id) {
		return m_excersiceManager.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Excersice> getAll() {
		return m_excersiceManager.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Excersice save(@RequestBody Excersice dto) {
		return m_excersiceManager.save(dto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		m_excersiceManager.delete(id);
	}
}
