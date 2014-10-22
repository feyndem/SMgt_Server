package org.mperezcastell.SMgtServer.service.repository;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Medication {
	
	@Id
	private String medName;

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}		
}
