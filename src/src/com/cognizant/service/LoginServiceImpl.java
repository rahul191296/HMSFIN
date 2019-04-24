package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.LoginDAO;
import com.cognizant.entity.Login;
import com.cognizant.model.LoginModel;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
    private LoginModel loginModel;
	
	@Autowired
	private LoginDAO loginDAO;
	
	public int checkLogin(LoginModel login) {
		Login loginObj=loginModel.loginModeltoEntity(login);
		return loginDAO.checkLogin(loginObj);
	}

}
