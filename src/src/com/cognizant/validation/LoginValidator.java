package com.cognizant.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.entity.Admin;
import com.cognizant.entity.Login;
import com.cognizant.model.LoginModel;
import com.cognizant.service.LoginService;

@Component(value="LoginValidator")
public class LoginValidator implements Validator{

	@Autowired
	private LoginService loginService;
	
	public boolean supports(Class<?> arg0) {
		return arg0.equals(LoginModel.class);
	}

	public void validate(Object arg0, Errors arg1) {
		LoginModel login=(LoginModel)arg0;
		int loginExists=loginService.checkLogin(login);
		
		if(loginExists==1){
			arg1.rejectValue("adminId", "com.cognizant.entity.Login.adminId.duplicate");
		}
		else if(loginExists==2){
			arg1.rejectValue("password","com.cognizant.entity.Login.password.duplicate");
		}else if(loginExists==3){
			arg1.rejectValue("adminId","com.cognizant.entity.Login.adminIdAndPassword.duplicate");
		}
		
	}

	

}
