package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    void add(Institution institution);
    List<Institution> getInstitutions();
    Optional<Institution> get(Long id);
    void delete(Long id);
}
