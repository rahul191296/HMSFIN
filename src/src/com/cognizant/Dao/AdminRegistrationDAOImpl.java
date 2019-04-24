package com.cognizant.Dao;

import java.math.BigDecimal;
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
import com.cognizant.helper.SessionCreator;

@Repository("AdminRegistrationDAOImpl")
public class AdminRegistrationDAOImpl implements AdminRegistrationDAO {

		@Autowired
		private SessionCreator sessionCreator;
		 
		public SessionCreator getSessionCreator() {
			return sessionCreator;
		}

		public void setSessionCreator(SessionCreator sessionCreator) {
			this.sessionCreator = sessionCreator;
		}

		public static final Logger logger=LoggerFactory.getLogger(AdminController.class);
		
//--------------------------------------------------------------------------------------------------------------------//
		
		//************FUNCTION TO RETERIVE ADMIN LIST************//
		public List<Admin> getAllAdmin() {
			logger.info("Reteriving Admin List");
			Session session=sessionCreator.createSession();
			Transaction tx=session.beginTransaction();
			List<Admin> adminList=session.createQuery("from Admin").list();
			tx.commit();
			return adminList;
		}

//--------------------------------------------------------------------------------------------------------------------//
		
		//************FUNCTION TO ADD ADMIN************//
		public Admin insertAdmin(Admin admin) {
		    logger.info("Adding Admin");
			generateAdminId();
			Session session=sessionCreator.createSession();
			Transaction tx=session.beginTransaction();
			session.persist(admin);
			tx.commit();
			int check=checkRegistration(admin);
			return admin;
		}
	
//--------------------------------------------------------------------------------------------------------------------//	
	
		//************FUNCTION TO GENERATE ADMIN ID************//
		public void  generateAdminId()
		{ 
		 logger.info("Generating Admin Id");
		 Session session=sessionCreator.createSession();
		 Transaction tx=session.beginTransaction();
		 Query query=session.createSQLQuery("select ADMINSEQ.nextval FROM DUAL");
		 Long key=((BigDecimal) query.uniqueResult()).longValue();
		 StoreAdminId.addId(key.intValue());
		 tx.commit();
		}

//--------------------------------------------------------------------------------------------------------------------//
 
		//************FUNCTION TO CHECK REGISTRATION DETAILS************//
		public int checkRegistration(Admin admin) {
			logger.info("Check Registration Details");
			Session session=sessionCreator.createSession();
			Transaction tx=session.beginTransaction();
			Query query = session.createQuery("from Admin o where o.contactNumber=:contactNumber");
			query.setParameter("contactNumber", admin.getContactNumber());
			List<Admin> contactList = query.list();

			Query query1 = session.createQuery("from Admin o where o.emailId=:emailId");
			query1.setString("emailId", admin.getEmailId());
			
			List<Admin> emailList = query1.list();
			tx.commit();
			
			int adminPersist = 0;

			if ((contactList.isEmpty()) && (emailList.isEmpty())) {

				adminPersist = 4;
			     	
			}
			else if (!(contactList.isEmpty())&& (emailList.isEmpty())) {

				adminPersist = 1;
				
			}
			else if (!(emailList.isEmpty()) && (contactList.isEmpty()) ) {
				adminPersist = 2;
			}
			else if (!(emailList.isEmpty()) && !(contactList.isEmpty())) {
				adminPersist = 3;
			}

			return adminPersist;
		}

}

