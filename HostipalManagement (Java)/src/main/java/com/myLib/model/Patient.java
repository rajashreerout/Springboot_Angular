package com.myLib.model;
import javax.persistence.*;
@Entity
public class Patient{

	@Id
	private String patientId;
	private String patientName;
	private int patientAge;
	private char patientGender;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public char getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(char patientGender) {
		this.patientGender = patientGender;
	}
}

