package novi.horsestall.repository;

import novi.horsestall.model.Membership;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Membership, Integer> {
    Iterable<Membership> findAllByNameContainingIgnoreCase(String name);

    Iterable<Membership> findAllByTypeOfHorseStall(String typeOfHorseStall);

    //    @Query("SELECT b FROM Book b WHERE b.title LIKE %:s%")    // using JPQL
//    or
    @Query(value = "SELECT * FROM books b WHERE b.title LIKE %:s%", nativeQuery = true)
    // using SQL
    Iterable<Membership> searchByTitleLike(@Param("s") String s);

}