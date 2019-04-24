package com.cognizant.Dao;

import java.util.List;

import com.cognizant.entity.Physician;

public interface PhysicianDetailsDAO {

	List<Physician> getAllPhysicians();

	boolean persistPhysician(Physician physician);

	Physician getPhysicianObject(String physicianId);

	boolean updatePhysician(Physician physician);

	int checkPhysician(Physician physician);
	
	List<String> getAllPhysiciansId();

}
