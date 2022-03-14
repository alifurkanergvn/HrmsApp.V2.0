package kodlamaio.hrmsApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsApp.entities.concretes.JobPositions;

public interface ProductDao extends JpaRepository<JobPositions,Integer>{
	
	

}
