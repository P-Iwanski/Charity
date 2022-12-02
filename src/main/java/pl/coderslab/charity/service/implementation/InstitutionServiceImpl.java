package pl.coderslab.charity.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {
    private final InstitutionRepository institutionRepository;
    @Override
    public void add(Institution institution) {
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
}
