package com.trainer.utils;

public enum UserType {
	TRAINER("ROLE_USER"),
	COACH("ROLE_ADMIN");
	
	private String role;
	
	private UserType(String role) {
		this.setRole(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
