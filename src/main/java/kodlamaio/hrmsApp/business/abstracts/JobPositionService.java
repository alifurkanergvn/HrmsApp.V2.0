package kodlamaio.hrmsApp.business.abstracts;

import java.util.List;

import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.JobPositions;

public interface JobPositionService {
	
	DataResult<List<JobPositions>>getAll();
	Result add(JobPositions jobPositions);
	

}
