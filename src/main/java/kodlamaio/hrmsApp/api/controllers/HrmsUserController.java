package kodlamaio.hrmsApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsApp.business.abstracts.HrmsUserService;
import kodlamaio.hrmsApp.entities.concretes.HrmsUser;

@RestController
@RequestMapping("/api/hrmsusers")
public class HrmsUserController {
	
	private HrmsUserService hrmsUserService;

	@Autowired
	public HrmsUserController(HrmsUserService hrmsUserService) {
		super();
		this.hrmsUserService = hrmsUserService;
	} 
	
	@GetMapping("/getall")
	public List<HrmsUser>getAll(){
		return this.hrmsUserService.getAll();
	}

}
