package kodlamaio.hrmsApp.core.utilities.verifications.abstracts;

import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.Employer;

public interface HrmsApproveService {
	
	public Result isApprovedFromUs(Employer employer);

}
