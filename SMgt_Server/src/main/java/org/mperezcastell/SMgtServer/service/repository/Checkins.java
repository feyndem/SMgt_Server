package org.mperezcastell.SMgtServer.service.repository;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Checkins implements Serializable {
	
	@Id
	private Timestamp checkTime;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "patient")
	@JsonBackReference
	private Patient patient;
	
	private PainLevels painLevel;
	private EatingStatus eatingStatus;
	
	public Checkins() {		
	}
	
	public Timestamp getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public PainLevels getPainLevel() {
		return painLevel;
	}
	public void setPainLevel(PainLevels painLevel) {
		this.painLevel = painLevel;
	}
	public EatingStatus getEatingStatus() {
		return eatingStatus;
	}
	public void setEatingStatus(EatingStatus eatingStatus) {
		this.eatingStatus = eatingStatus;
	}

}
