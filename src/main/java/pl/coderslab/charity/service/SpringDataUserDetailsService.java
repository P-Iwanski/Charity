package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
        User user = repository.findByLastName(lastName);
        if (user == null) {throw new UsernameNotFoundException(lastName); }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new CurrentUser(user.getLastName(),user.getPassword(),
                grantedAuthorities, user);
    }
}