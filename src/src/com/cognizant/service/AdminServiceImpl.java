package com.cognizant.service;

import java.util.List;

import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.AdminRegistrationDAO;
import com.cognizant.entity.Admin;
import com.cognizant.exception.SpringException;
import com.cognizant.model.AdminModel;
@Service
public class AdminServiceImpl implements AdminService {
	
	 @Autowired
	 private AdminRegistrationDAO adminDao;
	
	 @Autowired
	 private AdminModel adminModel;
	 
	 
	public List<Admin> getAllAdmin() {	
	return adminDao.getAllAdmin();
	}
	 
    //-----------------------------------------------------------------------------------------//
	
	public AdminModel persistsAdmin(AdminModel admin) {
		
		if(admin.getAge() < 18)
    	{
    		throw new SpringException("Given age is too low"); 
    	}
		
		Admin adminObj=adminModel.adminModeltoEntity(admin);
		adminObj=adminDao.insertAdmin(adminObj);
		admin=adminModel.adminEntitytoModel(adminObj);
		return admin;
	}

    //-----------------------------------------------------------------------------------------//	
	
	public int checkRegistration(AdminModel admin) {
		Admin adminObj=adminModel.adminModeltoEntity(admin);
		return adminDao.checkRegistration(adminObj);
	}
	
}
