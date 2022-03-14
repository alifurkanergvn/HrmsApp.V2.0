package kodlamaio.hrmsApp.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsApp.business.abstracts.JobSeekerService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.JobSeeker;


@CrossOrigin
@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
	
	
	private JobSeekerService jobSeekerService;
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>>getall(){
		return this.jobSeekerService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) throws RemoteException, Exception {
		return this.jobSeekerService.add(jobSeeker);
	}
}
