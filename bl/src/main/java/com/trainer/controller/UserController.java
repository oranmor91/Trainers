package com.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainer.dto.Trainer;
import com.trainer.manaager.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserManager m_userManager;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	@ResponseStatus(code=HttpStatus.OK)
    public Trainer get(@PathVariable Integer id) {
		return m_userManager.getUser(id);
    }
}
