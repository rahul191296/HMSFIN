package com.cognizant.model;

import org.springframework.stereotype.Component;

import com.cognizant.entity.Login;

@Component
public class LoginModel {
	public LoginModel(){}
	LoginModel loginModel=null;
	Login login=null;
	
	private String adminId;
	private String Password;
	

	
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public LoginModel loginEntitytoModel(Login login)
	{
	 loginModel=new LoginModel();
	 
	 loginModel.adminId=login.getAdminId();
	 loginModel.Password=login.getPassword();
	 
	 return loginModel;
	}
	
	public Login loginModeltoEntity(LoginModel loginModel)
	{
		login=new Login();
		
		login.setAdminId(loginModel.getAdminId());
		login.setPassword(loginModel.getPassword());
		
		return login;
	}

}
