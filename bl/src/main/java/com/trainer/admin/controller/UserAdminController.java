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

import com.trainer.dto.Program;
import com.trainer.dto.User;
import com.trainer.manaager.UserManager;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

	@Autowired
	private UserManager m_trainerManager;

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody User get(@PathVariable Integer id) {
		return m_trainerManager.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{userId}/{programDefId}")
	public @ResponseBody Program assignUserToProgram(@PathVariable Integer userId, @PathVariable Integer programDefId) {
		return m_trainerManager.assignUserToProgram(userId, programDefId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getAll() {
		return m_trainerManager.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User save(@RequestBody User dto) {
		return m_trainerManager.saveUser(dto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		m_trainerManager.delete(id);
	}
}