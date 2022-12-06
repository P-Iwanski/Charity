package pl.coderslab.charity.service;

import pl.coderslab.charity.model.RegisterDTO;
import pl.coderslab.charity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User u);
    void saveAdmin(User u);
    List<User> findAll();
    User findByLastName(String lastName);
    User registerUser(RegisterDTO dto);

    void update(User user);
    User findByEmail(String email);
    Optional<User> get(Long id);

    void delete(Long id);

}
