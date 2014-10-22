package org.mperezcastell.SMgtServer.service.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Patient {

	@Id
	private String patient;

	@ManyToOne
	@JoinColumn(name = "doctor")
	@JsonBackReference
	private Doctor doctor;
	
	public Patient() {
	}

	public Patient(String patient) {
		super();
		this.patient = patient;
	}
		
	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
