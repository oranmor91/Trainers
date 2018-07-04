package com.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
