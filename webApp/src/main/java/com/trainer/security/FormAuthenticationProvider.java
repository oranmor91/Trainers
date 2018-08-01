package com.trainer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.trainer.manaager.LoginManager;

public class FormAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private LoginManager loginManager;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return getLoginManager().login((String) authentication.getPrincipal(), (String)authentication.getPrincipal());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	public LoginManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

}
