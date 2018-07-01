package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.trainer.manaager.LoginManager;

@Service
@Scope("singleton")
public class LoginManagerImpl implements LoginManager{

	@Override
	public Authentication login(String id, String password) {
		Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UsernamePasswordAuthenticationToken(id, password, auth);
	}

}
