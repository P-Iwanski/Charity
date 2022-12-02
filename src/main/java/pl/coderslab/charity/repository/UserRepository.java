package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.lastName=:lastName")
    User findByLastName(@Param("lastName") String lastName);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    @Modifying
    void deleteUserById(Long id);
}