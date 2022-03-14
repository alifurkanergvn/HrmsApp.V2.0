package kodlamaio.hrmsApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.business.abstracts.JobAnnouncementService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.ErrorResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.dataAccess.abstracts.CityDao;
import kodlamaio.hrmsApp.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsApp.dataAccess.abstracts.JobAnnouncementDao;
import kodlamaio.hrmsApp.dataAccess.abstracts.JobPositionsDao;
import kodlamaio.hrmsApp.entities.concretes.JobAnnouncement;
import kodlamaio.hrmsApp.entities.dtos.JobAnnouncementDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobAnnouncementManager implements JobAnnouncementService{

	private JobAnnouncementDao jobAnnouncementDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobPositionsDao jobPositionsDao;

	@Autowired
	public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao, CityDao cityDao, EmployerDao employerDao,
			JobPositionsDao jobPositionsDao) {
		super();
		this.jobAnnouncementDao = jobAnnouncementDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobPositionsDao = jobPositionsDao;
	}

	@Override
	public Result add(JobAnnouncementDto jobAnnouncementDto) {
		
		JobAnnouncement jobAnnouncement = new JobAnnouncement();
		
		jobAnnouncement.setActive(jobAnnouncement.isActive()?false:true); //buna true parametresi geçilebilir ancak swagger kısmında false denemek için boş bıraktım. Bu sayede false atayabildim.
		jobAnnouncement.setMinSalary(jobAnnouncementDto.getMinSalary());
		jobAnnouncement.setMaxSalary(jobAnnouncementDto.getMaxSalary());
		jobAnnouncement.setDescription(jobAnnouncementDto.getDescription());
		jobAnnouncement.setOpenPositions(jobAnnouncementDto.getOpenPositions());
		jobAnnouncement.setApplicationDeadline(jobAnnouncementDto.getApplicationDeadline());
		jobAnnouncement.setReleaseDateTime(jobAnnouncementDto.getReleaseDateTime());
		
		jobAnnouncement.setJobPositions(this.jobPositionsDao.findJobPositionsById(jobAnnouncementDto.getJobPositionId()));
		jobAnnouncement.setJobPositions(this.jobPositionsDao.findByJobExplanation(jobAnnouncementDto.getJobExplanation()));
		jobAnnouncement.setCity(this.cityDao.findByCityId(jobAnnouncementDto.getCityId()));
		jobAnnouncement.setCity(this.cityDao.findByCityName(jobAnnouncementDto.getCityName()));
		jobAnnouncement.setEmployer(this.employerDao.getByEmployersIdList(jobAnnouncementDto.getEmployerId())); //ileride yazılacak manipülasyonlar id üzerinde gerçekleşir.(update, delete gibi)
		jobAnnouncement.setEmployer(this.employerDao.findEmployerByCompanyName(jobAnnouncementDto.getCompanyName()));
		
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Job announcement has been added");
	}

	@Override
	public Result delete(int announcementId) {
		this.jobAnnouncementDao.deleteById(announcementId);
		return new SuccessResult("Job announcment is deleted");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAll() {
		
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAll(),"Job announcements are listed");
	}

	@Override
	public DataResult<List<JobAnnouncement>> findAllByIsActiveTrue() {
		
		return new SuccessDataResult<>(this.jobAnnouncementDao.findAllByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC,"applicationDeadline");
		
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByIsActiveTrueOrderByApplicationDeadlineDesc(sort));
	}

	@Override
	public DataResult<List<JobAnnouncement>> findAllByEmployer_CompanyNameAndIsActiveTrue(String companyName) {
		
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByEmployer_CompanyNameAndIsActiveTrue(companyName),"Active Company Names are listed");
	}
	
	
	public DataResult<JobAnnouncement> getById(int id){
		return new SuccessDataResult<JobAnnouncement>(this.jobAnnouncementDao.getById(id));
	}
	
	public Result changeToUnActive(int id) {
		if(getById(id)== null) {
			return new ErrorResult("There is no job announcement ");
		}
		if (getById(id).getData().isActive()==false) {
			return new SuccessResult("This Job Announcement already closed");
		}
		JobAnnouncement jobAnnouncement=getById(id).getData();
		jobAnnouncement.setActive(false);
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Job announcment has been closed successfuly");
	}	
	
}
