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
import com.cognizant.entity.Diagnosis;
import com.cognizant.entity.Patient;
import com.cognizant.helper.SessionCreator;

@Repository("DiagnosisDetailsDAOImpl")
public class DiagnosisDetailsDAOImpl implements DiagnosisDetailsDAO{

	@Autowired
	private SessionCreator sessionCreator;
	
	 public SessionCreator getSessionCreator() {
			return sessionCreator;
		}

	public void setSessionCreator(SessionCreator sessionCreator) {
			this.sessionCreator = sessionCreator;
		}
	
	public static final Logger logger=LoggerFactory.getLogger(DiagnosisDetailsDAOImpl.class);

//--------------------------------------------------------------------------------------------------------------------//	   
	   
	 //************FUNCTION TO RETERIVE DIAGNOSIS LIST************//
	 public List<Diagnosis> getAllDiagnosis() {
		logger.info("Get All Diagnosis List ");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
	    List<Diagnosis> diagnosisList= session.createQuery("from Diagnosis").list();
	    tx.commit();
	    return diagnosisList;
	}
	 
//--------------------------------------------------------------------------------------------------------------------//

	//************FUNCTION TO ADD DIAGNOSIS DETAILS************//
	public boolean diagnosisPersist(Diagnosis diagnosis) {
		logger.info("Add Diagnosis Details");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		session.persist(diagnosis);
		tx.commit();
		return true;
	}

//--------------------------------------------------------------------------------------------------------------------//
	
	//************FUNCTION TO GET DIAGNOSIS OBJECT************//
	public Diagnosis getDiagnosisObject(String patientId) {
		logger.info("Get Diagnosis Object");
		Diagnosis diagnosis = null;
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Diagnosis o where o.patientId=:patientId");
		query.setParameter("patientId", patientId);
		List<Diagnosis> diagnosisList=query.list();
		tx.commit();
		for(Diagnosis diag:diagnosisList){
			diagnosis=diag;
		}
		return diagnosis;
	}

//--------------------------------------------------------------------------------------------------------------------//
	
	//************FUNCTION TO UPDATE DIAGNOSIS DETAILS************//
	public boolean updateDiagnosis(Diagnosis diagnosis) {
		boolean res=false;
		logger.info("Update Diagnosis Details");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
		session.merge(diagnosis);
		 res=true;
		tx.commit();
		return res;
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//************FUNCTION TO GENERATE REPORT ID************//
	public boolean getReportId(String patientId) {
		logger.info("Generating Report Id");
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
	    Query query= session.createQuery("select o.reportId from Diagnosis o where o.patientId=:patientId");
	    query.setParameter("patientId", patientId);
	    List<Integer> diagnosisList=query.list();
	    tx.commit();
	    if(diagnosisList.isEmpty())
	    	{return true;}
	    else{
	    return false ;
	    }
	}

//--------------------------------------------------------------------------------------------------------------------//
	
	//************FUNCTION TO RETERIVE PARTICLUAR REPORT DATA************//
	public Diagnosis getReportDetail(String patientId) {
		logger.info("Getting report details");
		Diagnosis diagnosis=null;
		Session session=sessionCreator.createSession();
		Transaction tx=session.beginTransaction();
	    Query query= session.createQuery("from Diagnosis o where o.patientId=:patientId");
	    query.setParameter("patientId", patientId);
	    List<Diagnosis> diagnosisList=query.list();
	    tx.commit();
	    for(Diagnosis diag:diagnosisList){
	    	diagnosis=diag;
	    }
	    return diagnosis;
	}
}
