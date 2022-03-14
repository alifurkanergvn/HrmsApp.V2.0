package kodlamaio.hrmsApp.business.abstracts;

import java.util.List;

import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.JobAnnouncement;
import kodlamaio.hrmsApp.entities.dtos.JobAnnouncementDto;

public interface JobAnnouncementService {
	
	
	Result add (JobAnnouncementDto jobAnnouncementDto);

	Result delete(int announcementId);
	
	DataResult<List<JobAnnouncement>> getAll();
	
	DataResult<List<JobAnnouncement>> findAllByIsActiveTrue();
	
	DataResult<List<JobAnnouncement>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	 
	DataResult<List<JobAnnouncement>> findAllByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	Result changeToUnActive(int id);
	

}
