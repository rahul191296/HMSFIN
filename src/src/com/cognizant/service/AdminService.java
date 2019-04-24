package com.cognizant.service;

import java.util.List;

import javax.servlet.Registration;

import com.cognizant.entity.Admin;
import com.cognizant.model.AdminModel;

public interface AdminService {
	
	List<Admin>getAllAdmin();
    
	AdminModel persistsAdmin(AdminModel admin);

	int checkRegistration(AdminModel admin);

}
