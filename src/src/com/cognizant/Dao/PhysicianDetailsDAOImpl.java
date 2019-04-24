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
import com.cognizant.entity.Patient;
import com.cognizant.entity.Physician;
import com.cognizant.helper.SessionCreator;

@Repository("PhysicianDetailsDAOImpl")
public class PhysicianDetailsDAOImpl implements PhysicianDetailsDAO{

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
    
  //****************FUNCTION TO RETERIVE PHYSICIAN LIST********************//
	public List<Physician> getAllPhysicians() {
		logger.info("Reteriving Physician List");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		List<Physician> physicianList=session.createQuery("from Physician").list();
		tx.commit();
		return physicianList;
	}

//--------------------------------------------------------------------------------------------------------------------//	
	
	//****************FUNCTION TO PERSIST PHYSICIAN********************//
	public boolean persistPhysician(Physician physician) {
		logger.info("Persisting Physicain");
		generatePhysicianId();
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		session.persist(physician);
		tx.commit();
		return true;
	}

//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO RETERIVE PHYSICIAN OBJECT********************//
	public Physician getPhysicianObject(String physicianId) {
		logger.info("Getting Physician Object");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Physician physician=(Physician) session.load(Physician.class, physicianId);
		tx.commit();
		return physician;
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO GENERATE PHYSICIAN ID********************//
	public void  generatePhysicianId()
	{
	 logger.info("Generating Physicain Id");
	 Session session=sessionCreator.createSession();
	 Transaction tx=session.beginTransaction();
	 Query query=session.createSQLQuery("select PHYSICIANSEQ.nextval FROM DUAL");
	 Long key=((BigDecimal) query.uniqueResult()).longValue();
	 StorePhyId.addId(key.intValue());
	 tx.commit();
	}

//--------------------------------------------------------------------------------------------------------------------//

	//****************FUNCTION TO UPDATE PHYSICIAN DETAILS********************//
	public boolean updatePhysician(Physician physician) {
		logger.info("Updating Physician Details");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(physician);
		boolean res=true;
		tx.commit();
		return res;
	}

//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO CHECK PHYSICIAN DETAILS********************//
	public int checkPhysician(Physician physician) {
		logger.info("Check Physician Details");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Physician o where o.contactNumber=:contactNumber");
		query.setParameter("contactNumber", physician.getContactNumber());
		List<Physician>contactList=query.list();
		
		Query query1=session.createQuery("from Physician o where o.emailId=:emailId");
		query1.setString("emailId", physician.getEmailId());
	    List<Physician>emailList=query.list();
	    
	    tx.commit();
	    
		int physicianPersist=0;
		
		if ((contactList.isEmpty()) && (emailList.isEmpty())) {

			physicianPersist = 4;
		     	
		}
		else if (!(contactList.isEmpty())&& (emailList.isEmpty())) {

			physicianPersist = 1;
			
		}
		else if (!(emailList.isEmpty()) && (contactList.isEmpty()) ) {
			physicianPersist = 2;
		}
		else if (!(emailList.isEmpty()) && !(contactList.isEmpty())) {
			physicianPersist = 3;
		}
		return physicianPersist;
	}

//-------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO RETERIVE ALL PHYSICIANS ID********************//
	public List<String> getAllPhysiciansId() {
		logger.info("Reteriving All Physician's Id");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		List<String> physicianIdList=session.createQuery("select o.physicianId from Physician o ").list();
		tx.commit();
		return physicianIdList;
	}
}
