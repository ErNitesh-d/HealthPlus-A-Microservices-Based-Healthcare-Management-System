package com.tcs.billingmicroservice.dto;

public class DoctorDto {
	int doctorId;
	String firstName;
	String lastName;
	int experience;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public DoctorDto(int doctorId, String firstName, String lastName, int experience) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
	}
	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
