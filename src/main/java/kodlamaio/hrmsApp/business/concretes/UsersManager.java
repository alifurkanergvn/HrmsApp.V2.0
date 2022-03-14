package kodlamaio.hrmsApp.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsApp.business.abstracts.UsersService;
import kodlamaio.hrmsApp.core.utilities.results.DataResult;
import kodlamaio.hrmsApp.core.utilities.results.Result;
import kodlamaio.hrmsApp.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsApp.core.utilities.results.SuccessResult;
import kodlamaio.hrmsApp.dataAccess.abstracts.UsersDao;
import kodlamaio.hrmsApp.entities.concretes.Users;

@Service
@Transactional
public class UsersManager implements UsersService {

	private UsersDao usersDao;
	
	@Autowired
	public UsersManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}



	@Override
	public DataResult<List<Users>> getAll() {
		
		return new SuccessDataResult<List<Users>>
		(this.usersDao.findAll(), "Users data listed");
				
	}
	
	
	public Result add(Users users) {
		this.usersDao.save(users);
		return new SuccessResult("Users added");
	}
	
	
}
