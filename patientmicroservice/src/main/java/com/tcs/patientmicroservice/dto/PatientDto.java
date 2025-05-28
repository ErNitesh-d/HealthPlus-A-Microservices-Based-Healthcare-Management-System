package com.tcs.patientmicroservice.dto;


public class PatientDto {
	private Integer patientId;
	private String patientName;
	private Integer age;
	private String gender;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public PatientDto(int patientId, String patientName, int age, String gender) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.gender = gender;
	}
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
