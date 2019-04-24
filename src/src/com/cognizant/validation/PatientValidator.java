package com.cognizant.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.entity.Patient;
import com.cognizant.exception.SpringException;
import com.cognizant.model.PatientModel;
import com.cognizant.service.PatientService;

@Component("PatientValidator")
public class PatientValidator implements Validator{

	@Autowired
	private PatientService patientService;
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(PatientModel.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		PatientModel patient=(PatientModel)arg0;
		int patientExists=patientService.checkPatient(patient);
		
		if(patientExists==1){
			
				arg1.rejectValue("contactNumber", "com.cognizant.entity.Patient.contactNumber.duplicate");
				
		}
		
		else if(patientExists==2){
			
				arg1.rejectValue("emailId","com.cognizant.entity.Patient.emailId.duplicate");
				
		}
		
		else if(patientExists==3){
			
				arg1.rejectValue("contactNumber", "com.cognizant.entity.Patient.contactNumber.duplicate");
				arg1.rejectValue("emailId","com.cognizant.entity.Patient.emailId.duplicate");
				
		
	}
	}
}
