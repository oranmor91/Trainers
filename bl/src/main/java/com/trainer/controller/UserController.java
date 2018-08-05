package com.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainer.dto.User;
import com.trainer.manaager.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserManager m_userManager;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody User get() {
		return m_userManager.getMySelf();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User save(@RequestBody User dto) {
		return m_userManager.saveUser(dto);
	}
	
}
