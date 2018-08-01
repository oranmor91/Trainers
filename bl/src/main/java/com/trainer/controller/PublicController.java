package com.trainer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainer.dto.User;
import com.trainer.manaager.UserManager;
import com.trainer.model.UserCredentials;

@Controller
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private UserManager m_userManager;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager m_authManager;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public @ResponseBody User save(@RequestBody User dto) {
		return m_userManager.saveAdmin(dto);
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public @ResponseBody User login(HttpServletRequest request, HttpServletResponse response, @RequestBody UserCredentials credentials) {
		HttpSession session = request.getSession();
		
		if (session != null)
			session.invalidate();
		
		request.getSession(true);
		
        Authentication authenticationToken  = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        	Authentication authentication = m_authManager.authenticate(authenticationToken);
        	SecurityContextHolder.getContext().setAuthentication(authentication);
        return m_userManager.getUserByUniqueID(credentials.getEmail());
	}
}
