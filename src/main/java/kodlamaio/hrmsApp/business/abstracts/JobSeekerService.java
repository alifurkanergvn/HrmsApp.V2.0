package kodlamaio.hrmsApp.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>>getAll();
	
	Result add(JobSeeker jobSeeker) throws RemoteException, Exception;
	
	
	

}
