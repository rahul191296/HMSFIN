package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.PhysicianDetailsDAO;
import com.cognizant.entity.Physician;
import com.cognizant.exception.SpringException;
import com.cognizant.model.PhysicianModel;

@Service
public class PhysicianServiceImpl implements PhysicianService{

	@Autowired
	private PhysicianModel physicianModel;
	
	@Autowired
	private PhysicianDetailsDAO physicainDetailsDAO;

	
	public boolean physicianPersist(PhysicianModel physician) {
		// TODO Auto-generated method stub
		
		if(physician.getAge()<20)
		{
			throw new SpringException("Age can not less than 20");
		}
	
		if(physician.getZipCode().length()>6)
		{
			throw new SpringException("Invalid ZipCode");
		}
		
		Physician physicianObj=physicianModel.physicianModeltoEntity(physician);
		return physicainDetailsDAO.persistPhysician(physicianObj);
	}

	
	public List<Physician> getAllPhysicians() {
		// TODO Auto-generated method stub
		return physicainDetailsDAO.getAllPhysicians();
	}

	
	public PhysicianModel getPhysicianObject(String physicianId) {
		
		Physician physician=physicainDetailsDAO.getPhysicianObject(physicianId);
		PhysicianModel physicianObj=physicianModel.physicianEntitytoModel(physician);
		
		return physicianObj;
	}


	public boolean physicianUpdate(PhysicianModel physician) {
		// TODO Auto-generated method stub
		
		 if(physician.getZipCode().length()>6)
			{
				throw new SpringException("Invalid ZipCode");
			}
		 
		 if(physician.getAge()<20)
			{
				throw new SpringException("Age can not be less than 20");
			}
		
		Physician physicianObj=physicianModel.physicianModeltoEntity(physician);
		return physicainDetailsDAO.updatePhysician(physicianObj);
	}

	public int checkPhysician(PhysicianModel physician) {
		// TODO Auto-generated method stub
		Physician physicianObj=physicianModel.physicianModeltoEntity(physician);
		return physicainDetailsDAO.checkPhysician(physicianObj);
	}


	@Override
	public List<String> getAllPhysiciansId() {
		// TODO Auto-generated method stub
		return physicainDetailsDAO.getAllPhysiciansId();
	}


}
