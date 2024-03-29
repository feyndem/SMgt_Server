package org.mperezcastell.SMgtServer.service.repository;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Patient {

	@Id
	private String recordNumber;
	
	private String firstName;
	private String lastName;
	private Date birthDate;

	@ManyToOne
	@JoinColumn(name = "doctor")
	@JsonBackReference
	private Doctor doctor;
	
	@ManyToMany
	private Set<Medication> medications;
	
	@OneToMany(mappedBy = "patient")
	@JsonManagedReference
	private Set<MedicineIngestion> medsCheckins;
	
	@OneToMany(mappedBy = "patient")
	@JsonManagedReference
	private Set<Checkins> checkins;
	
	public Patient() {
	}

	public Patient(String recordNumber, String firstName, String lastName, Date birthDate) {
		super();
		this.recordNumber = recordNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
		
	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
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
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Set<Medication> getMedications() {
		return medications;
	}
	
	public void setMedications(Set<Medication> medications) {
		this.medications = medications;
	}
	
	public Set<MedicineIngestion> getMedsCheckins() {
		return medsCheckins;
	}
	
	public void setMedsCheckins(Set<MedicineIngestion> medsCheckins) {
		this.medsCheckins = medsCheckins;
	}
	

}
