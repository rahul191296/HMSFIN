package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Patient;
import com.cognizant.model.PatientModel;

public interface PatientService {

	List<Patient> getAllPatients();
	boolean patientPersist(PatientModel patient);
	int checkPatient(PatientModel patient);
	PatientModel getPatientObject(String patientId);
	boolean patientUpdate(PatientModel patient);
}
