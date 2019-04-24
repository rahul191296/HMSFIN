package com.cognizant.service;

import com.cognizant.entity.Login;
import com.cognizant.model.LoginModel;

public interface LoginService {

	int checkLogin(LoginModel login);
}
