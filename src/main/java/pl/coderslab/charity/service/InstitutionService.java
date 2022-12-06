package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.InstitutionDTO;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    void add(InstitutionDTO institutionDTO);
    List<Institution> getInstitutions();
    Optional<Institution> get(Long id);
    void delete(Long id);
    void updateEdit(InstitutionDTO institutionDTO);
}
