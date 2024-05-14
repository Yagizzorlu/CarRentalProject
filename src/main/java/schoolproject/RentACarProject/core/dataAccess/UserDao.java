package schoolproject.RentACarProject.core.dataAccess;



import org.springframework.data.jpa.repository.JpaRepository;

import schoolproject.RentACarProject.core.entities.User;

public interface UserDao extends JpaRepository<User , Integer> {
	User findByEmail(String email);
}
