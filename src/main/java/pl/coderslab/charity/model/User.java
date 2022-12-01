package pl.coderslab.charity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int enabled;
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    private Set<Role> roles;

}
