package kodlamaio.hrmsApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsApp.business.abstracts.JobPositionService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.entities.concretes.JobPositions;

@RestController
@RequestMapping("/api/JobPositions")
public class JobPositionController {
	
	@Autowired
	private JobPositionService jobPositionService;
	
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPositions>>getAll(){
		return this.jobPositionService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPositions jobPositions) {
		return this.jobPositionService.add(jobPositions);
	}
	
}
