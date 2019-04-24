package com.cognizant.Dao;

import java.util.List;

import com.cognizant.entity.Patient;

public interface PatientDetailsDAO {

	List<Patient> getAllPatients();

	boolean persistPatient(Patient patient);

	int checkPatient(Patient patient);
	
	Patient getPatientObject(String patientId);

	boolean updatePatient(Patient patient);

}
