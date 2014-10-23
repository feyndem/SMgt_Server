package org.mperezcastell.SMgtServer.service.repository;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Medication {
	
	@Id
	private String medName;
	
	@OneToMany(mappedBy = "medicine")
	@JsonManagedReference
	private Set<MedicineIngestion> medsCheckins;

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}	
	
	public Set<MedicineIngestion> getMedsCheckins() {
		return medsCheckins;
	}
	
	public void setMedsCheckins(Set<MedicineIngestion> medsCheckins) {
		this.medsCheckins = medsCheckins;
	}
}
