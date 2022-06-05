package novi.horsestall.repository;

import novi.horsestall.model.Horse;
import org.springframework.data.repository.CrudRepository;

public interface HorseRepository extends CrudRepository<Horse, Integer> {
    Iterable<Horse> findAllByNameContainingIgnoreCase(String name);
}