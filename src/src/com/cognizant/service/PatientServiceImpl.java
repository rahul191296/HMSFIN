package com.cognizant.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.PatientDetailsDAO;
import com.cognizant.entity.Patient;
import com.cognizant.exception.SpringException;
import com.cognizant.model.PatientModel;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDetailsDAO patientDetailsDAO;
	
	@Autowired
    private PatientModel patientModel;
	
	//----------------------------------------------------------------------------------------//
	
	public List<Patient> getAllPatients() {
		
		return patientDetailsDAO.getAllPatients();
	}

	//----------------------------------------------------------------------------------------//
	
	public boolean patientPersist(PatientModel patient) {
		
		if(patient.getZipCode().length()!=6)
		{
			throw new SpringException("Invalid ZipCode");
		}
		
		Patient patientObj=patientModel.patientModeltoEntity(patient);
		return patientDetailsDAO.persistPatient(patientObj);
	}

	//----------------------------------------------------------------------------------------//
	
	public int checkPatient(PatientModel patient) {
		// TODO Auto-generated method stub
		Patient patientObj=patientModel.patientModeltoEntity(patient);
		return patientDetailsDAO.checkPatient(patientObj);
	}

	//----------------------------------------------------------------------------------------//
	
	public PatientModel getPatientObject(String patientId) {
		// TODO Auto-generated method stub
		Patient patientObj=patientDetailsDAO.getPatientObject(patientId);
		PatientModel patientModel1=patientModel.patientEntitytoModel(patientObj);
		return patientModel1;
	}

	//----------------------------------------------------------------------------------------//
	
	public boolean patientUpdate(PatientModel patient) {
		// TODO Auto-generated method stub
		
		if(patient.getZipCode().length()!=6)
		{
			throw new SpringException("Invalid ZipCode");
		}
		
		Patient patientObj=patientModel.patientModeltoEntity(patient);
		return patientDetailsDAO.updatePatient(patientObj);
	}

}
