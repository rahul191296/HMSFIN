package com.cognizant.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.entity.Patient;

@Component
public class PatientModel {
	public PatientModel(){}
	PatientModel patientModel=null;
	Patient patient=null;
	
	private String patientId ;
	private String firstName;
	private String lastName;
	private int age;
	private String doB;
	private String gender;
	private String contactNumber;
	private String altContactNumber;
	private String emailId;
	private String password;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	
	
	
	
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDoB() {
		return doB;
	}

	public void setDoB(String doB) {
		this.doB = doB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAltContactNumber() {
		return altContactNumber;
	}

	public void setAltContactNumber(String altContactNumber) {
		this.altContactNumber = altContactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public PatientModel patientEntitytoModel(Patient patient)
	{
		patientModel=new PatientModel();
		patientModel.patientId=patient.getPatientId();
		patientModel.firstName=patient.getFirstName();
		patientModel.lastName=patient.getLastName();
		patientModel.age=patient.getAge();
		patientModel.gender=patient.getGender();
		patientModel.doB=patient.getDoB();
		patientModel.contactNumber=patient.getContactNumber();
		patientModel.altContactNumber=patient.getAltContactNumber();
		patientModel.emailId=patient.getEmailId();
		patientModel.password=patient.getPassword();
		patientModel.addressLine1=patient.getAddressLine1();
		patientModel.addressLine2=patient.getAddressLine2();
		patientModel.city=patient.getCity();
		patientModel.zipCode=patient.getZipCode();
		patientModel.state=patient.getState();
		
		return patientModel;
	}
	
	public Patient patientModeltoEntity(PatientModel patientModel)
	{
		patient=new Patient();
		
		patient.setPatientId(patientModel.getPatientId());
		patient.setFirstName(patientModel.getFirstName());
		patient.setLastName(patientModel.getLastName());
		patient.setAge(patientModel.getAge());
		patient.setGender(patientModel.getGender());
		patient.setDoB(patientModel.getDoB());
		patient.setContactNumber(patientModel.getContactNumber());
		patient.setAltContactNumber(patientModel.getAltContactNumber());
		patient.setEmailId(patientModel.getEmailId());
		patient.setPassword(patientModel.getPassword());
		patient.setAddressLine1(patientModel.getAddressLine1());
		patient.setAddressLine2(patientModel.getAddressLine2());
		patient.setCity(patientModel.getCity());
		patient.setZipCode(patientModel.getZipCode());
		patient.setState(patientModel.getState());
		
		return patient;
	}

	public List<PatientModel> patientEntitytoModel(List<Patient> patientList) {
		List<PatientModel> patientModelList=new ArrayList<PatientModel>();
		for(int i=0;i<patientList.size();i++)
		{
			patientModelList.add(patientEntitytoModel(patientList.get(i)));
		}
		return patientModelList;
	}

	

}
