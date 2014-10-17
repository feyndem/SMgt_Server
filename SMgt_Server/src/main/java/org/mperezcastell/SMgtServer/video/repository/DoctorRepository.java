package org.mperezcastell.SMgtServer.video.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{

	public Collection<Doctor> findByDoctor(String doctor);
		
}
