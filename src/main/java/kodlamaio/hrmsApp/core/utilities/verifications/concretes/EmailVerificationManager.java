package kodlamaio.hrmsApp.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.core.utilities.verifications.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		
		return new SuccessResult();
	}
	
	public static boolean checkEmailDomain(String companyWebsite, String email) {
		return companyWebsite.contains(email.split("@")[1]);
	}
	

}
