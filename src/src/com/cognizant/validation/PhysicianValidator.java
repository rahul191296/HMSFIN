package com.cognizant.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.cognizant.entity.Physician;
import com.cognizant.exception.SpringException;
import com.cognizant.model.PhysicianModel;
import com.cognizant.service.PhysicianService;

@Component("PhysicianValidator")
public class PhysicianValidator implements Validator{

		@Autowired
		private PhysicianService physicianService;
		
		
		@Override
		public boolean supports(Class<?> arg0) {
			// TODO Auto-generated method stub
			return arg0.equals(PhysicianModel.class);
		}

		@Override
		public void validate(Object arg0, Errors arg1) {
			PhysicianModel physician=(PhysicianModel)arg0;
			int physicianExists=physicianService.checkPhysician(physician);
			
			if(physicianExists==1){
				
					arg1.rejectValue("contactNumber", "com.cognizant.entity.Physician.contactNumber.duplicate");
			}
			
			else if(physicianExists==2){
				
					arg1.rejectValue("emailId","com.cognizant.entity.Physician.emailId.duplicate");
	
			}
			
			else if(physicianExists==3){
				
					arg1.rejectValue("contactNumber", "com.cognizant.entity.Physician.contactNumber.duplicate");
					arg1.rejectValue("emailId","com.cognizant.entity.Physician.emailId.duplicate");
					
			}
		}

}
