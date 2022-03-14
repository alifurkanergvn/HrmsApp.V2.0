package kodlamaio.hrmsApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.business.abstracts.HrmsUserService;
import kodlamaio.hrmsApp.dataAccess.abstracts.HrmsDao;
import kodlamaio.hrmsApp.entities.concretes.HrmsUser;

@Service
public class HrmsUserManager implements HrmsUserService{
	
	
	private HrmsDao hrmsDao;
	
	@Autowired
	public HrmsUserManager(HrmsDao hrmsDao) {
		super();
		this.hrmsDao = hrmsDao;
	}

	@Override
	public List<HrmsUser> getAll() {
		
		return this.hrmsDao.findAll();
	}
	

}
