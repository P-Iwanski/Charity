package pl.coderslab.charity.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InstitutionDTO {
    @NotNull
    private String name;
    @NotNull
    private String description;

    public Institution map(){
        Institution institution = new Institution();
        institution.setName(this.name);
        institution.setDescription(this.description);
        return institution;
    }
}
