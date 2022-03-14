package kodlamaio.hrmsApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrmsApp.entities.concretes.JobSeeker;
import kodlamaio.hrmsApp.entities.concretes.Users;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

	List<JobSeeker> findByIdentityNo(long identityNo);
	Users findByEmail(String email);
	
}
