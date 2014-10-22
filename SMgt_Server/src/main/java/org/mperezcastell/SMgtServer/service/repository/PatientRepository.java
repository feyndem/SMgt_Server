package org.mperezcastell.SMgtServer.service.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{

	public Collection<Patient> findByRecordNumber(String recordNumber);
		
}
