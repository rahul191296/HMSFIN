package com.cognizant.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.controller.AdminController;
import com.cognizant.entity.Admin;
import com.cognizant.entity.Login;
import com.cognizant.helper.SessionCreator;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	private SessionCreator sessionCreator;
	
	public static final Logger logger=LoggerFactory.getLogger(LoginDAOImpl.class);

//---------------------------------------------------------------------------------------------------------------------//
	
	//*****************FUNCTION TO CHECK LOGIN DETAILS*****************//
	public int checkLogin(Login login) {
		logger.info("Checking Login Details");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select o from Admin o where o.adminId=:adminId and o.password=:password");
		query.setParameter("adminId", login.getAdminId());
		query.setParameter("password", login.getPassword());
		List<Login> loginList=query.list();
		
		Query query1=session.createQuery("select o from Admin o where o.adminId=:adminId");
		query1.setParameter("adminId", login.getAdminId());
		List<Login> loginList1=query.list();
		
		Query query2=session.createQuery("select o from Admin o where o.password=:password");
		query2.setParameter("password", login.getPassword());
		List<Login> loginList2=query.list();
		List<Admin> List2=query.list();
		int adminExists=0;
		
		
			if((loginList != null) && (loginList.size()>0))
			{
				
				adminExists=4;
				
			}
			if((loginList1.isEmpty()))
			{
			
				adminExists=1;
			}
			if((loginList2.isEmpty()))
			{
				adminExists=2;
			}
			if((loginList2.isEmpty()) && (loginList1.isEmpty())){
				adminExists=3;
			}
		return adminExists;
	}
}
