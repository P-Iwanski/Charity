package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Role;

public interface RoleService {
    Role findByName(String name);
    public Role save(Role role);

}
