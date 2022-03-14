package kodlamaio.hrmsApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsApp.entities.concretes.HrmsUser;

public interface HrmsDao extends JpaRepository<HrmsUser,Integer >{

	
}
