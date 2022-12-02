package pl.coderslab.charity.service;

import pl.coderslab.charity.model.RegisterDTO;
import pl.coderslab.charity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User u);
    User saveAdmin(User u);
    List<User> findAll();
    User findByLastName(String lastName);
    User registerUser(RegisterDTO dto);

    void update(User user);
    Optional<User> findByEmail(String email);

}
