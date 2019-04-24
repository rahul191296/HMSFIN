package com.cognizant.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.entity.Admin;

@Component
public class AdminModel {
	public AdminModel(){}
	AdminModel adminModel=null;
	Admin admin=null;
	
	private String adminId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String doB;
	private String contactNumber;
	private String altContactNumber;
	private String emailId;
	private String  password;
	
	
	
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



	public AdminModel adminEntitytoModel(Admin admin)
     {
    	 adminModel=new AdminModel();
    	 
    	 adminModel.adminId=admin.getAdminId();
    	 adminModel.firstName=admin.getFirstName();
    	 adminModel.lastName=admin.getLastName();
    	 adminModel.age=admin.getAge();
    	 adminModel.doB=admin.getDoB();
    	 adminModel.gender=admin.getGender();
    	 adminModel.contactNumber=admin.getContactNumber();
    	 adminModel.altContactNumber=admin.getAltContactNumber();
    	 adminModel.emailId=admin.getEmailId();
    	 adminModel.password=admin.getPassword();
    	 
    	 
    	 return adminModel;
      }
     
     
     
     public Admin adminModeltoEntity(AdminModel adminModel)
     {
    	 admin=new Admin();
    	 
    	 admin.setAdminId(adminModel.getAdminId());
    	 admin.setFirstName(adminModel.getFirstName());
    	 admin.setLastName(adminModel.getLastName());
    	 admin.setAge(adminModel.getAge());
    	 admin.setDoB(adminModel.getDoB());
    	 admin.setGender(adminModel.getGender());
    	 admin.setContactNumber(adminModel.getContactNumber());
    	 admin.setAltContactNumber(adminModel.getAltContactNumber());
    	 admin.setEmailId(adminModel.getEmailId());
    	 admin.setPassword(adminModel.getPassword());
    	 
    	 return admin;
     }
     
     /*public List<AdminModel> adminListToAdminModelList(List<Admin> adminList){
    	 
    	 
		return null;
    	 
     }*/
}
