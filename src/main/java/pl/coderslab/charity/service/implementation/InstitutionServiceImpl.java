package pl.coderslab.charity.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.InstitutionDTO;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    @Override
    public void add(InstitutionDTO institutionDTO) {
        Institution institution = institutionDTO.map();
        institutionRepository.save(institution);
    }

    @Override
    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public Optional<Institution> get(Long id) {
        return institutionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteInstitutionById(id);
    }

    @Override
    public void updateEdit(InstitutionDTO institutionDTO) {
        Institution institution = institutionDTO.map();
        institutionRepository.save(institution);
    }
}
