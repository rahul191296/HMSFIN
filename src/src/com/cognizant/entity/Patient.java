package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Patient")
public class Patient {
	
	@Id
	@GenericGenerator(name="PATIENTSEQ",
	strategy="com.cognizant.Dao.PatientIdGenerator")
	@GeneratedValue(generator="PATIENTSEQ")
	@Column(name="Patient_Id")
	private String patientId;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Age")
	private int age;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="DoB")
	private String doB;
	
	@Column(name="Contact_Number")
	private String contactNumber;
	
	@Column(name="Alt_Contact_Number")
	private String altContactNumber;
	
	@Column(name="Email_Id")
	private String emailId;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Address_Line1")
	private String addressLine1;
	
	@Column(name="Address_Line2")
	private String addressLine2;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Zip_Code")
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDoB() {
		return doB;
	}

	public void setDoB(String doB) {
		this.doB = doB;
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
	
	
	
}
