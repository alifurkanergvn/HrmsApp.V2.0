package kodlamaio.hrmsApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrmsApp.entities.concretes.Users;


public interface UsersDao extends JpaRepository<Users, Integer>{
	
	//Users findByEmail(String email);
}
