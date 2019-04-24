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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Patient;
import com.cognizant.helper.SessionCreator;

@Repository("PatientDetailsDAOImpl")
public class PatientDetailsDAOImpl implements PatientDetailsDAO {

	@Autowired
    private SessionCreator sessionCreator;
	
	public SessionCreator getSessionCreator() {
		return sessionCreator;
	}

	public void setSessionCreator(SessionCreator sessionCreator) {
		this.sessionCreator = sessionCreator;
	}

	public static final Logger logger=LoggerFactory.getLogger(LoginDAOImpl.class);
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO RETERIVE PATIENT LIST********************//
	public List<Patient> getAllPatients() {
		logger.info("Reteriving Patient List");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		List<Patient> patientList=session.createQuery("from Patient").list();
	    tx.commit();
		return patientList;
	}

//--------------------------------------------------------------------------------------------------------------------//

	//****************FUNCTION TO PERSIST PATIENT********************//
	public boolean persistPatient(Patient patient) {
		logger.info("Persisting Patient");
		generatePatientId();
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		session.persist(patient);
		tx.commit();
		return true;
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO CHECK PATIENT********************//
	public int checkPatient(Patient patient) {
		logger.info("Check Patient Details");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("from Patient o where o.contactNumber=:contactNumber");
		query.setParameter("contactNumber", patient.getContactNumber());
		List<Patient> contactList = query.list();

		Query query1 = session.createQuery("from Patient o where o.emailId=:emailId");
		query1.setString("emailId", patient.getEmailId());
		
		List<Patient> emailList = query1.list();

		
		int patientPersist = 0;

		if ((contactList.isEmpty()) && (emailList.isEmpty())) {

			patientPersist = 4;
		     	
		}
		else if (!(contactList.isEmpty())&& (emailList.isEmpty())) {

			patientPersist = 1;
			
		}
		else if (!(emailList.isEmpty()) && (contactList.isEmpty()) ) {
			patientPersist = 2;
		}
		else if (!(emailList.isEmpty()) && !(contactList.isEmpty())) {
			patientPersist = 3;
		}

		tx.commit();
		return patientPersist;
	}
	
//--------------------------------------------------------------------------------------------------------------------//

	//****************FUNCTION TO RETERIVE PATIENT OBJECT********************//
	public Patient getPatientObject(String patientId) {
		logger.info("Reteriving Patient Object");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Patient patient=(Patient) session.load(Patient.class, patientId);
		tx.commit();
		return patient;
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO GENERATE PATIENT ID********************//
	public void  generatePatientId()
	{
		logger.info("Generate Patient Id");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createSQLQuery("select PATIENTSEQ.nextval FROM DUAL");
		Long key=((BigDecimal) query.uniqueResult()).longValue();
		StorePatId.addId(key.intValue());
		tx.commit();
	}

//--------------------------------------------------------------------------------------------------------------------//
	
	//****************FUNCTION TO UPDATE PATIENT LIST********************//
	public boolean updatePatient(Patient patient) {
		logger.info("Updating Patient List");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(patient);
		boolean res=true;
		tx.commit();
		return res;
	}	
}


