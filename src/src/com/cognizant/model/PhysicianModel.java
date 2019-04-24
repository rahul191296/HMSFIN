package com.cognizant.model;

import org.springframework.stereotype.Component;

import com.cognizant.entity.Physician;

@Component
public class PhysicianModel {
	public PhysicianModel() {
	}

	PhysicianModel physicianModel = null;
	Physician physician = null;

	private String  physicianId;
	private String  firstName;
	private String  lastName;
	private int  age;
	private String  gender;
	private String  doB;
	private String  contactNumber;
	private String  altContactNumber;
	private String  emailId;
	private String  password;
	private String  addressLine1;
	private String  addressLine2;
	private String  city;
	private String  state;
	private String  zipCode;
	private String  degree;
	private String  speciality;
	private String  workHours;
	private String  hospitalName;
	
	
	
	
	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	

	

	public PhysicianModel physicianEntitytoModel(Physician physician) {
		physicianModel = new PhysicianModel();
		physicianModel.physicianId = physician.getPhysicianId();
		physicianModel.firstName = physician.getFirstName();
		physicianModel.lastName = physician.getLastName();
		physicianModel.age = physician.getAge();
		physicianModel.gender = physician.getGender();
		physicianModel.doB = physician.getDoB();
		physicianModel.contactNumber = physician.getContactNumber();
		physicianModel.altContactNumber = physician.getAltContactNumber();
		physicianModel.emailId = physician.getEmailId();
		physicianModel.password = physician.getPassword();
		physicianModel.addressLine1 = physician.getAddressLine1();
		physicianModel.addressLine2 = physician.getAddressLine2();
		physicianModel.city = physician.getCity();
		physicianModel.state = physician.getState();
		physicianModel.zipCode = physician.getZipCode();
		physicianModel.degree = physician.getDegree();
		physicianModel.speciality = physician.getSpeciality();
		physicianModel.workHours = physician.getWorkHours();
		physicianModel.hospitalName = physician.getHospitalName();

		return physicianModel;

	}

	public Physician physicianModeltoEntity(PhysicianModel physicianModel) {
		physician = new Physician();

		physician.setPhysicianId(physicianModel.getPhysicianId());
		physician.setFirstName(physicianModel.getFirstName());
		physician.setLastName(physicianModel.getLastName());
		physician.setAge(physicianModel. getAge());
		physician.setGender(physicianModel.getGender());
		physician.setDoB(physicianModel.getDoB() );
		physician.setContactNumber(physicianModel.getContactNumber());
		physician.setAltContactNumber(physicianModel.getAltContactNumber());
		physician.setEmailId(physicianModel.getEmailId());
		physician.setPassword(physicianModel.getPassword());
		physician.setAddressLine1(physicianModel.getAddressLine1());
		physician.setAddressLine2(physicianModel.getAddressLine2());
		physician.setCity(physicianModel.getCity());
		physician.setZipCode(physicianModel.getZipCode());
		physician.setDegree(physicianModel.getDegree());
		physician.setSpeciality(physicianModel.getSpeciality());
		physician.setWorkHours(physicianModel.getWorkHours());
		physician.setHospitalName(physicianModel.getHospitalName());
		physician.setState(physicianModel.getState());
	
		return physician;
	}
}
