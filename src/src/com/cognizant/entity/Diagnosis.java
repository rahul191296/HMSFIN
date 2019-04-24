package com.cognizant.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Diagnosis_Details")
public class Diagnosis {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Report_Id")
	private int reportId;
	@Column(name="Patient_Id")
	private String patientId;
	@Column(name="Physician_Id")
	private String physicianId;
	@Column(name="Service_date")
	private String serviceDate;
	@Column(name="Test_Result_Date")
	private String testResultDate;
	@Column(name="Blood_WBC_AR")
	private String wbcActualRange;
	@Column(name="Blood_WBC_NR")
	private String  wbcNormalrange;
	@Column(name="Blood_RBC_AR")
	private String rbcActualRange;
	@Column(name="Blood_RBC_NR")
	private String  rbcNormalrange;
	
	@Column(name="Blood_HGB_AR")
	private String hgbActualRange;
	@Column(name="Blood_HGB_NR")
	private String  hgbNormalrange;
	@Column(name="Blood_HCT_AR")
	private String hctActualRange;
	@Column(name="Blood_HCT_NR")
	private String  hctNormalrange;
	@Column(name="Blood_MCV_AR")
	private String mvcActualRange;
	@Column(name="Blood_MVC_NR")
	private String  mvcNormalrange;
	@Column(name="Blood_MCH_AR")
	private String mchActualRange;
	@Column(name="Blood_MCH_NR")
	private String  mchNormalrange;
	
	@Column(name="Physician_Comments")
	private String physicianComments;
	@Column(name="Other_Info")
	private String  otherInfo;
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
	public void setWbcNormalrange(String wbcNormalrange1) {
		this.wbcNormalrange = wbcNormalrange1;
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
	
	


}
