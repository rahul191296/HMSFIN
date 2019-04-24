package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Diagnosis;
import com.cognizant.model.DiagnosisModel;

public interface DiagnosisService {

	List<Diagnosis>getAllDiagnosis();
	boolean diagnosisPersist(DiagnosisModel diagnosis);
	boolean diagnosisUpdate(DiagnosisModel diagnosis);
	DiagnosisModel getDiagnosisObject(String patientId);
	boolean getReportId(String patientId);
	DiagnosisModel getReportDetail(String patientId);

}
