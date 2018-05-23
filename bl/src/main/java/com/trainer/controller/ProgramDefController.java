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

import com.trainer.dto.ProgramDef;
import com.trainer.manaager.ProgramDefManager;

@Controller
@RequestMapping("/programDef")
public class ProgramDefController {

	@Autowired
	private ProgramDefManager m_programDefManager;;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody ProgramDef get(@PathVariable Integer id) {
		return m_programDefManager.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ProgramDef> getAll() {
		return m_programDefManager.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ProgramDef save(@RequestBody ProgramDef dto) {
		return m_programDefManager.save(dto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		m_programDefManager.delete(id);
	}
}
