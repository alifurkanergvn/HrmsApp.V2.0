package kodlamaio.hrmsApp.core.utilities.verifications.abstracts;

import kodlamaio.hrmsApp.core.utilities.results.Result;

public interface EmailVerificationService {
	
	public Result verifyEmail(String email);
}
