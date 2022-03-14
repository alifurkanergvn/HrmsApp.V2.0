package kodlamaio.hrmsApp.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.core.utilities.verifications.abstracts.HrmsApproveService;
import kodlamaio.hrmsApp.entities.concretes.Employer;

@Service
public class HrmsApproveManager implements HrmsApproveService{

	@Override
	public Result isApprovedFromUs(Employer employer) {
		
		return new SuccessResult();
	}
	

}
