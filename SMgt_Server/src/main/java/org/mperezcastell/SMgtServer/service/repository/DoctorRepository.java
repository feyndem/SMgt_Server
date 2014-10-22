package org.mperezcastell.SMgtServer.service.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{

	public List<Doctor> findByDoctor(String doctor);
		
}
