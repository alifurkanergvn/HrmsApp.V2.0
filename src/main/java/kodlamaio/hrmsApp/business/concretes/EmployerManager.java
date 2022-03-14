package kodlamaio.hrmsApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.business.abstracts.EmployerService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.ErrorResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrmsApp.core.utilities.verifications.abstracts.HrmsApproveService;
import kodlamaio.hrmsApp.core.utilities.verifications.concretes.EmailVerificationManager;
import kodlamaio.hrmsApp.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsApp.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private HrmsApproveService hrmsApproveService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			HrmsApproveService hrmsApproveService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.hrmsApproveService = hrmsApproveService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data Listelendi");
	}

	//.isBlank() = str.length()==0 
	private boolean dataControl(Employer employer) {
		if (employer.getEmail()== null || employer.getEmail().length()==0 ||
			employer.getCompanyName()== null || employer.getCompanyName().length()==0||
			employer.getTelephoneNo()==null  || employer.getTelephoneNo().length()==0 ||
			employer.getPassword() ==null    || employer.getPassword().length()==0 ||
			employer.getCompanyWebsite() == null || employer.getCompanyWebsite().length()==0 ){
				return false;
			}else {
				return true;
			}
	}
	
	@Override
	public Result add(Employer employer) {
		if(!dataControl(employer)) {
			return new ErrorResult("Please fill out all fields");
		}
		else if (this.employerDao.findByEmail(employer.getEmail())!=null) {
			return new ErrorResult("You have entered a used mail address!");
		}
		else if (!EmailVerificationManager.checkEmailDomain(employer.getCompanyWebsite(), employer.getEmail() )) {
			return new ErrorResult("Your web address domain is not mach your email");
		}
		else if (!this.hrmsApproveService.isApprovedFromUs(employer).isSuccess()) {
			return new ErrorResult("Your registration is not approved from H.R personel yet");
		}
		else if (!this.emailVerificationService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Check you email please");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("Employer saved succesfully");
		}
	
		 
	}


	@Override
	public DataResult<Employer> getByEmail(String email) {
		
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}




}
