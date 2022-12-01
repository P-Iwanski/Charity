package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;
    public Role findByName(String name) {
        return repository.findByName(name);
    }
    public Role save(Role role) {
        return repository.save(role);
    }
}
