package schoolproject.RentACarProject.business.concretes;

import org.springframework.stereotype.Service;

import schoolproject.RentACarProject.business.abstracts.UserService;
import schoolproject.RentACarProject.core.dataAccess.UserDao;
import schoolproject.RentACarProject.core.entities.User;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;
import schoolproject.RentACarProject.core.utilities.results.SuccessDataResult;
import schoolproject.RentACarProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>
		(this.userDao.findByEmail(email),"Kullanıcı bulundu.");
	}

}
