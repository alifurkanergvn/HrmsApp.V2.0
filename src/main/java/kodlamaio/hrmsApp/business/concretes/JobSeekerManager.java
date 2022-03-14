package kodlamaio.hrmsApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.business.abstracts.JobSeekerService;
import kodlamaio.hrmsApp.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.ErrorResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrmsApp.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsApp.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	
	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService,
			EmailVerificationService emailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
	}	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"Job Seekers datas has been listed ");
				
	}

	
	private Result isEmailExist(String email) {
		if(this.jobSeekerDao.findByEmail(email)!= null) {
			return new ErrorResult("You have entered a used mail address!");
		}
 	return new SuccessResult("You can use your mail address");
	}


	private Result isIdentityNoExist(long identityNo) {
		if(this.jobSeekerDao.findByIdentityNo(identityNo)!= null) {
			return new ErrorResult("You have entered invalid identity no!");
		}
		return new SuccessResult();
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws Exception {
		Result checkedPerson = mernisCheckService.checkIfRealPerson(jobSeeker);
		
		
		if(!this.isEmailExist(jobSeeker.getEmail()).isSuccess() || !this.isIdentityNoExist(jobSeeker.getIdentityNo()).isSuccess()){
			return new ErrorResult("You have entered invalid identity no or You have entered a used mail address!");
		}
		
		else if(!checkedPerson.isSuccess()) {
			return new ErrorResult("Person not a valid");
			
			//mernis validation is complete
		}
		
		else if (!this.emailVerificationService.verifyEmail(jobSeeker.getEmail()).isSuccess()) {
			return new ErrorResult("Check your email please");
		}
		else { 
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Job seeker saved succesfuly");
		} 
	}

	
	
	
}
