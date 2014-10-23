package org.mperezcastell.SMgtServer.service.repository;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class MedicineIngestion implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "patient")
	@JsonBackReference
	@Id
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "medication")
	@JsonBackReference
	@Id
	private Medication medicine;
	
	private Timestamp IngestionTime;
	
	public MedicineIngestion() {		
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medication getMedicine() {
		return medicine;
	}

	public void setMedicine(Medication medicine) {
		this.medicine = medicine;
	}

	public Timestamp getIngestionTime() {
		return IngestionTime;
	}

	public void setIngestionTime(Timestamp ingestionTime) {
		IngestionTime = ingestionTime;
	} 
	
	

}
