package com.trainer.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.trainer.entity.UserEntity;
import com.trainer.manaager.LoginManager;
import com.trainer.manaager.UserManager;
import com.trainer.utils.UserType;

@Service
@Scope("singleton")
public class LoginManagerImpl implements LoginManager{

	@Autowired
	private UserManager m_userManager;
	
	@Override
	public Authentication login(String uniqueID, String password) {
		UserEntity user = m_userManager.getByUniqueID(uniqueID);
		
		if (user == null)
			return null;

		Collection<GrantedAuthority> auth = convertRoles(user.getRoles());
		return new UsernamePasswordAuthenticationToken(uniqueID, password, auth);
	}

	private Collection<GrantedAuthority> convertRoles(Set<UserType> roles) {
		Collection<GrantedAuthority> results = new ArrayList<GrantedAuthority>();
	
		for (UserType role : roles)
			results.add(new SimpleGrantedAuthority(role.getRole()));
		
		return results;
	}
}
