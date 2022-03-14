package kodlamaio.hrmsApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsApp.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions, Integer>{
	
	JobPositions findByJobExplanation(String jobExplanation);
	
	JobPositions findJobPositionsById(int id);
	JobPositions findJobPositionsByJobExplanation(String jobExplanation);
}
