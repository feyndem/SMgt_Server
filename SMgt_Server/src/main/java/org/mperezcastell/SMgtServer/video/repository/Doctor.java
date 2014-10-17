package org.mperezcastell.SMgtServer.video.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	private String doctor;

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

}
