package novi.horsestall.repository;

import novi.horsestall.model.Membership;
import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Membership, Integer> {
    Iterable<Membership> findAllByTypeContainingIgnoreCase(String type);

    Iterable<Membership> findAllByTypeOfHorseStall(String typeOfHorseStall);
}