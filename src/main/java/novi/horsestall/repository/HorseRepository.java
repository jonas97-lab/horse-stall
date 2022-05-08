package novi.horsestall.repository;

import novi.horsestall.model.Horse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface HorseRepository extends CrudRepository<Horse, Integer> {
    Iterable<Horse> findAllByNameContainingIgnoreCase(String name);
    Iterable<Horse> findAllByFoodType(String foodType);

    //    @Query("SELECT b FROM Book b WHERE b.title LIKE %:s%")    // using JPQL
//    or
    @Query(value = "SELECT * FROM books b WHERE b.title LIKE %:s%", nativeQuery = true) // using SQL
    Iterable<Horse> searchByTitleLike(@Param("s") String s);

}