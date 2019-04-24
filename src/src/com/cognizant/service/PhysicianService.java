package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Physician;
import com.cognizant.model.PhysicianModel;

public interface PhysicianService {

	boolean physicianPersist(PhysicianModel physician);

	List<Physician> getAllPhysicians();

	PhysicianModel getPhysicianObject(String physicianId);

	boolean physicianUpdate(PhysicianModel physician);

	int checkPhysician(PhysicianModel physician);
	
	List<String> getAllPhysiciansId();	

}
