package kodlamaio.hrmsApp.business.abstracts;

import java.util.List;

import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.Users;

public interface UsersService {

	DataResult<List<Users>>getAll();
	
	Result add(Users users);
	
}
