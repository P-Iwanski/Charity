package pl.coderslab.charity.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;

@Data
public class RegisterDTO {//obiekt DTO czyli Data Transfer Object, wykorzystywany do mapowania formularzy html na obiekt javy
    //  some DTO from browseSpring @Controller method Spring @Service method mozliwa walidacja w DTO
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @Size(min = 6)
    private String password;
    @Size(min = 6)
    private String confirm_password;

    public User map(Role role) {
        if(!this.password.equals(this.confirm_password)) {
            return null;
        }
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setEnabled(2);
        user.setRoles(new HashSet<>(List.of(role)));
        return user;
    }
}
