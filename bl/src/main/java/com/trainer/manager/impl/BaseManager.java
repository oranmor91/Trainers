package com.trainer.manager.impl;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.trainer.dto.BaseDto;
import com.trainer.entity.UserEntity;
import com.trainer.manaager.UserManager;
import com.trainer.utils.FilterUtils;

public class BaseManager {

	public String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null)
			return null;
		
		return (String) authentication.getPrincipal();
	}
	
	public <DTO extends BaseDto> void filterDtosByCoach(Collection<DTO> dtos, UserManager m_userManager) {
		UserEntity caoch = m_userManager.getUserEntityByUniqueID(getLoggedInUser());
		FilterUtils.filter(dtos, caoch.getId());
	}
	
	public <DTO extends BaseDto> void setCoachId(DTO dto, UserManager m_userManager) {
		String loggedInUser = getLoggedInUser();
		
		if (loggedInUser == null)
			throw new RuntimeException("Failed to find loggin user.");
		
		UserEntity admin = m_userManager.getUserEntityByUniqueID(loggedInUser);
		
		if (admin == null)
			throw new RuntimeException("Failed to find loggin user.");
		
		dto.setCoachId(admin.getId());
	}
}
