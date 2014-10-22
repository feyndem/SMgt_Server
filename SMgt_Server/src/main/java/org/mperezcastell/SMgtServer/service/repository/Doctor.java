package org.mperezcastell.SMgtServer.service.repository;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor {

	@Id
	private String doctor;
	
	@OneToMany(mappedBy = "doctor")
	@JsonManagedReference
	private Set<Patient> patients;

	public Doctor() {
	}

	public Doctor(String doctor) {
		super();
		this.doctor = doctor;
	}
		
	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public Set<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
