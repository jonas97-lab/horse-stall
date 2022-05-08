package novi.horsestall.repository;

import novi.horsestall.model.HorseStall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface HorseStallRepository extends CrudRepository<HorseStall, Integer> {
    Iterable<HorseStall> findAllByNameContainingIgnoreCase(String name);
    Iterable<HorseStall> findAllBySize(String size);

    //    @Query("SELECT b FROM Book b WHERE b.title LIKE %:s%")    // using JPQL
//    or
    @Query(value = "SELECT * FROM books b WHERE b.title LIKE %:s%", nativeQuery = true) // using SQL
    Iterable<HorseStall> searchByTitleLike(@Param("s") String s);

}