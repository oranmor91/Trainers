package com.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainer.dto.Program;
import com.trainer.manaager.ProgramManager;

@Controller
@RequestMapping("/program")
public class PersonalProgramController {

	@Autowired
	private ProgramManager m_programManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Program get() {
		return m_programManager.getMyCurrentProgram();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK)
	public void fillRmData(@RequestBody Program program) throws Exception {
		m_programManager.fillRmData(program);
	}
}
