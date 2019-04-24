package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Admin")

public class Admin {
	@Id
	@GenericGenerator(name="ADMINSEQ",
	strategy="com.cognizant.Dao.AdminIdGenerator")
	@GeneratedValue(generator="ADMINSEQ")
	@Column(name="Admin_Id")
	private String adminId;
	
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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
	
	
	
	
}
