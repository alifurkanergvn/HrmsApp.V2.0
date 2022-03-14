package kodlamaio.hrmsApp.core.utilities.adapters.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.JobSeeker;

public interface MernisCheckService {
	Result checkIfRealPerson(JobSeeker jobSeeker) throws RemoteException;
	
}
