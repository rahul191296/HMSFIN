package com.cognizant.model;

import org.springframework.stereotype.Component;

import com.cognizant.entity.Diagnosis;

@Component
public class DiagnosisModel {
	public DiagnosisModel(){}
	DiagnosisModel diagnosisModel=null;
	Diagnosis diagnosis=null;
	
	private int    reportId;
	private String patientId;
	private String physicianId;
	private String serviceDate;
	private String testResultDate;
	private String wbcActualRange;
	private String wbcNormalrange;
	private String rbcActualRange;
	private String rbcNormalrange;
	private String hgbActualRange;
	private String hgbNormalrange;
	private String hctActualRange;
	private String hctNormalrange;
	private String mvcActualRange;
	private String mvcNormalrange;
	private String mchActualRange;
	private String mchNormalrange;
	private String physicianComments;
	private String otherInfo;
	
	
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getTestResultDate() {
		return testResultDate;
	}

	public void setTestResultDate(String testResultDate) {
		this.testResultDate = testResultDate;
	}

	public String getWbcActualRange() {
		return wbcActualRange;
	}

	public void setWbcActualRange(String wbcActualRange) {
		this.wbcActualRange = wbcActualRange;
	}

	public String getWbcNormalrange() {
		return wbcNormalrange;
	}

	public void setWbcNormalrange(String wbcNormalrange) {
		this.wbcNormalrange = wbcNormalrange;
	}

	public String getRbcActualRange() {
		return rbcActualRange;
	}

	public void setRbcActualRange(String rbcActualRange) {
		this.rbcActualRange = rbcActualRange;
	}

	public String getRbcNormalrange() {
		return rbcNormalrange;
	}

	public void setRbcNormalrange(String rbcNormalrange) {
		this.rbcNormalrange = rbcNormalrange;
	}

	public String getHgbActualRange() {
		return hgbActualRange;
	}

	public void setHgbActualRange(String hgbActualRange) {
		this.hgbActualRange = hgbActualRange;
	}

	public String getHgbNormalrange() {
		return hgbNormalrange;
	}

	public void setHgbNormalrange(String hgbNormalrange) {
		this.hgbNormalrange = hgbNormalrange;
	}

	public String getHctActualRange() {
		return hctActualRange;
	}

	public void setHctActualRange(String hctActualRange) {
		this.hctActualRange = hctActualRange;
	}

	public String getHctNormalrange() {
		return hctNormalrange;
	}

	public void setHctNormalrange(String hctNormalrange) {
		this.hctNormalrange = hctNormalrange;
	}

	public String getMvcActualRange() {
		return mvcActualRange;
	}

	public void setMvcActualRange(String mvcActualRange) {
		this.mvcActualRange = mvcActualRange;
	}

	public String getMvcNormalrange() {
		return mvcNormalrange;
	}

	public void setMvcNormalrange(String mvcNormalrange) {
		this.mvcNormalrange = mvcNormalrange;
	}

	public String getMchActualRange() {
		return mchActualRange;
	}

	public void setMchActualRange(String mchActualRange) {
		this.mchActualRange = mchActualRange;
	}

	public String getMchNormalrange() {
		return mchNormalrange;
	}

	public void setMchNormalrange(String mchNormalrange) {
		this.mchNormalrange = mchNormalrange;
	}

	public String getPhysicianComments() {
		return physicianComments;
	}

	public void setPhysicianComments(String physicianComments) {
		this.physicianComments = physicianComments;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public DiagnosisModel diagnosisEntitytoModel(Diagnosis diagnosis)
	{ 
	  diagnosisModel=new DiagnosisModel();
	  
	  diagnosisModel.reportId=diagnosis.getReportId();
	  diagnosisModel.patientId=diagnosis.getPatientId();
	  diagnosisModel.physicianId=diagnosis.getPhysicianId();
	  diagnosisModel.serviceDate=diagnosis.getServiceDate();
	  diagnosisModel.testResultDate=diagnosis.getTestResultDate();
	  diagnosisModel.wbcActualRange=diagnosis.getWbcActualRange();
	  diagnosisModel.wbcNormalrange=diagnosis.getWbcNormalrange();
	  diagnosisModel.rbcActualRange=diagnosis.getRbcActualRange();
	  diagnosisModel.rbcNormalrange=diagnosis.getRbcNormalrange();
	  diagnosisModel.hgbActualRange=diagnosis.getHgbActualRange();
	  diagnosisModel.hgbNormalrange=diagnosis.getHgbNormalrange();
	  diagnosisModel.hctActualRange=diagnosis.getHctActualRange();
	  diagnosisModel.hctNormalrange=diagnosis.getHctNormalrange();
	  diagnosisModel.mvcActualRange=diagnosis.getMvcActualRange();
	  diagnosisModel.mvcNormalrange=diagnosis.getMvcNormalrange();
	  diagnosisModel.mchActualRange=diagnosis.getMchActualRange();
	  diagnosisModel.mchNormalrange=diagnosis.getMchNormalrange();
	  diagnosisModel.physicianComments=diagnosis.getPhysicianComments();
	  diagnosisModel.otherInfo=diagnosis.getOtherInfo();
	  
	  return diagnosisModel;
	}
	  
	 public Diagnosis diagnosisModeltoEntity(DiagnosisModel diagnosisModel){
		 diagnosis=new Diagnosis();
		 diagnosis.setReportId(diagnosisModel.getReportId());
		 System.out.println(diagnosis.getReportId());
		 diagnosis.setPhysicianId(diagnosisModel.getPhysicianId());
		 diagnosis.setPatientId(diagnosisModel.getPatientId() );
		 System.out.println(diagnosis.getPatientId());
		 diagnosis.setServiceDate(diagnosisModel.getServiceDate());
		 diagnosis.setTestResultDate(diagnosisModel.getTestResultDate());
		 diagnosis.setWbcActualRange(diagnosisModel.getWbcActualRange());
		 diagnosis.setWbcNormalrange(diagnosisModel. getWbcNormalrange());
		 diagnosis.setRbcActualRange(diagnosisModel.getRbcActualRange() );
		 diagnosis.setRbcNormalrange(diagnosisModel.getRbcNormalrange() );
		 diagnosis.setHgbActualRange(diagnosisModel.getHgbActualRange());
		 diagnosis.setHgbNormalrange(diagnosisModel.getHgbNormalrange());
		 diagnosis.setHctActualRange(diagnosisModel.getHctActualRange());
		 diagnosis.setHctNormalrange(diagnosisModel.getHctNormalrange());
		 diagnosis.setMvcActualRange(diagnosisModel.getMvcActualRange());
		 diagnosis.setMvcNormalrange(diagnosisModel.getMvcNormalrange() );
		 diagnosis.setMchActualRange(diagnosisModel.getMchActualRange());
		 diagnosis.setMchNormalrange(diagnosisModel.getMchNormalrange());
		 diagnosis.setPhysicianComments(diagnosisModel.getPhysicianComments());
		 diagnosis.setOtherInfo(diagnosisModel.getOtherInfo());
        
		 return diagnosis;
	 }
}

