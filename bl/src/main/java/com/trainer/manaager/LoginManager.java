package com.trainer.manaager;

import org.springframework.security.core.Authentication;

public interface LoginManager {

	public Authentication login(String id, String password);

}
