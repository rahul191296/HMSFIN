package com.cognizant.Dao;

import java.util.List;

import com.cognizant.entity.Diagnosis;
import com.cognizant.model.DiagnosisModel;

public interface DiagnosisDetailsDAO {
	
	List<Diagnosis> getAllDiagnosis();

	boolean diagnosisPersist(Diagnosis diagnosis);
	
	boolean updateDiagnosis(Diagnosis diagnosis);

	Diagnosis getDiagnosisObject(String patientId);
	
	boolean getReportId(String patientId);

	Diagnosis getReportDetail(String patientId);
}
