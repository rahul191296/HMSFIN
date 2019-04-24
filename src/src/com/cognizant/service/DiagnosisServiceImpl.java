package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.DiagnosisDetailsDAO;
import com.cognizant.entity.Diagnosis;
import com.cognizant.model.DiagnosisModel;

@Service
public class DiagnosisServiceImpl implements DiagnosisService{

	@Autowired
	private DiagnosisDetailsDAO diagnosisDetailsDAO;
	
	@Autowired
	DiagnosisModel diagnosisModel;
	
	public List<Diagnosis> getAllDiagnosis() {
		// TODO Auto-generated method stub
		return diagnosisDetailsDAO.getAllDiagnosis();
	}

	public boolean diagnosisPersist(DiagnosisModel diagnosis) {
		// TODO Auto-generated method stub
		Diagnosis diagnosisObj=diagnosisModel.diagnosisModeltoEntity(diagnosis);
		return diagnosisDetailsDAO.diagnosisPersist(diagnosisObj);
	}

	public DiagnosisModel getDiagnosisObject(String patientId) {
		Diagnosis diagnosisObj=diagnosisDetailsDAO.getDiagnosisObject(patientId);
		DiagnosisModel diagnosisModel1=diagnosisModel.diagnosisEntitytoModel(diagnosisObj);
		return diagnosisModel1;
	}

	public boolean diagnosisUpdate(DiagnosisModel diagnosis) {
		// TODO Auto-generated method stub
		Diagnosis diagnosisObj=diagnosisModel.diagnosisModeltoEntity(diagnosis);
		return diagnosisDetailsDAO.updateDiagnosis(diagnosisObj);
	}

	
	public boolean getReportId(String patientId) {
		// TODO Auto-generated method stub
		return diagnosisDetailsDAO.getReportId(patientId);
	}

	public DiagnosisModel  getReportDetail(String patientId) {
		// TODO Auto-generated method stub
		Diagnosis diagnosisObj=diagnosisDetailsDAO.getReportDetail(patientId);
		DiagnosisModel diagnosisModel1=diagnosisModel.diagnosisEntitytoModel(diagnosisObj);
		return diagnosisModel1;
	} 

	
	

}
