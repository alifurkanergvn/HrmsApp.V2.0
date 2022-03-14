package kodlamaio.hrmsApp.core.utilities.adapters.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrmsApp.core.utilities.results.ErrorResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(JobSeeker jobSeeker) throws RemoteException {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result= kpsPublicSoapProxy.TCKimlikNoDogrula((jobSeeker.getIdentityNo()),
				jobSeeker.getName().toUpperCase(new Locale("tr","TR")),
				jobSeeker.getSurname().toUpperCase(new Locale("tr","TR")),
				(jobSeeker.getYearOfBirth()));
		
		if(!result) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	

}
