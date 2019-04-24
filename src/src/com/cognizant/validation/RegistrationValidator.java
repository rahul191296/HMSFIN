package com.cognizant.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.entity.Admin;
import com.cognizant.exception.SpringException;
import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;


@Component(value="RegistrationValidator")
public class RegistrationValidator implements Validator{
	
	@Autowired
	private AdminService adminService;
	
	public boolean supports(Class<?> arg0) {
		
		return arg0.equals(AdminModel.class);
	}

	
	public void validate(Object arg0, Errors arg1) {
		AdminModel admin=(AdminModel)arg0;
		int adminExists=adminService.checkRegistration(admin);
		
		if(adminExists==1){
			 
				 arg1.rejectValue("contactNumber", "com.cognizant.entity.Admin.contactNumber.duplicate");
	
		}
			
		else if(adminExists==2){
			  
				  arg1.rejectValue("emailId","com.cognizant.entity.Admin.emailId.duplicate");
		}
		
		else if(adminExists==3){
			
				arg1.rejectValue("contactNumber", "com.cognizant.entity.Admin.contactNumber.duplicate");
				arg1.rejectValue("emailId","com.cognizant.entity.Admin.emailId.duplicate");
				
		}
	}
}
