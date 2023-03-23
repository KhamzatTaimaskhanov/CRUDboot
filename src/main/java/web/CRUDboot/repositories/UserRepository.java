package web.CRUDboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.CRUDboot.model.User;
//import web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
