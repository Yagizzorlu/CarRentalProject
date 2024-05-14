package schoolproject.RentACarProject.business.abstracts;

import schoolproject.RentACarProject.core.entities.User;
import schoolproject.RentACarProject.core.utilities.results.DataResult;
import schoolproject.RentACarProject.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
