package org.mperezcastell.SMgtServer.video.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	private String patient;

	public Patient() {
	}

	public Patient(String patient) {
		super();
		this.patient = patient;
	}
		
	public String getUser() {
		return patient;
	}

	public void setUser(String user) {
		this.patient = user;
	}

}
