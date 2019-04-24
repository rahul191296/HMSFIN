package com.cognizant.Dao;

import java.util.List;

import com.cognizant.entity.Admin;
import com.cognizant.model.AdminModel;


public interface AdminRegistrationDAO {
	
	List<Admin>getAllAdmin();
	Admin insertAdmin(Admin admin);
	int checkRegistration(Admin admin);
}
