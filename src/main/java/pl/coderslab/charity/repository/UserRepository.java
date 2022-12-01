package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.lastName=:lastName")
    User findByLastName(@Param("lastName") String lastName);
}