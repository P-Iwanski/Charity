package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select MAX(r) from Role r where r.name=:name")
    Role findByName(@Param("name") String name);

}