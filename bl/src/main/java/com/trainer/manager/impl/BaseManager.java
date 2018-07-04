package com.trainer.manager.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseManager {

	public String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null)
			return null;
		
		return (String) authentication.getPrincipal();
	}
}
