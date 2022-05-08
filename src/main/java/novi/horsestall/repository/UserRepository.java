package novi.horsestall.repository;

import novi.horsestall.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}