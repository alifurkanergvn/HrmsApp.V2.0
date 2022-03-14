package kodlamaio.hrmsApp.business.abstracts;

import java.util.List;

import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>>getAll();
	
	Result add(Employer employer);
	
	DataResult<Employer>getByEmail(String email);
	
}
