package kodlamaio.hrmsApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsApp.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	Employer findByEmail(String email);
	
	//Employer findByEmployer_User_Id(int user_id);
	@Query("From Employer where id=:id")
	Employer getByEmployersIdList(int id);
	
	Employer findEmployerByCompanyName(String companyName);

}
