package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.RegisterDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(2);
        Role userRole = roleRepository.findByName("ROLE_USER");
        u.setRoles(new HashSet<Role>(List.of(userRole)));
        return userRepository.save(u);
    }
    public User saveAdmin(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,adminRole)));
        return userRepository.save(u);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }
    public User registerUser(RegisterDTO dto) {

        User user = dto.map(roleRepository.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
