package org.mperezcastell.SMgtServer.video.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{

	public Collection<Patient> findByPatient(String patient);
		
}
