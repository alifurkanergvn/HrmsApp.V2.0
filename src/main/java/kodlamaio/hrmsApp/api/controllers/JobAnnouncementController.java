package kodlamaio.hrmsApp.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsApp.business.abstracts.JobAnnouncementService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsApp.entities.concretes.JobAnnouncement;
import kodlamaio.hrmsApp.entities.dtos.JobAnnouncementDto;
import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/api/job_announcements")
public class JobAnnouncementController {
	
	private JobAnnouncementService jobAnnouncementService;

	public JobAnnouncementController(JobAnnouncementService jobAnnouncementService) {
		super();
		this.jobAnnouncementService = jobAnnouncementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAnnouncement>> getAll(){
		return this.jobAnnouncementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAnnouncementDto jobAnnouncementDto) {
		return this.jobAnnouncementService.add(jobAnnouncementDto);
	}
	
	@GetMapping("/getAllActiveJob")
	public DataResult<List<JobAnnouncement>> findAllByIsActiveTrue(){
		return this.jobAnnouncementService.findAllByIsActiveTrue();
	}
	
	@GetMapping("/getAllActiveDeadlineDesc")
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
		return this.jobAnnouncementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
	}
	
	@GetMapping("/getAllActiveCompanyNames")
	public DataResult<List<JobAnnouncement>> findAllByEmployer_CompanyNameAndIsActiveTrue(@RequestParam String companyName) {
		return this.jobAnnouncementService.findAllByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}
	
	@PostMapping("/changeToUnActive")
	public Result changeToUnActive( int id) {
		return this.jobAnnouncementService.changeToUnActive(id);
	}
}
