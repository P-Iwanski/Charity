package pl.coderslab.charity.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;
    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }
    @Override
    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }
    @Override
    public Optional<Donation> get(Long id) {
        return donationRepository.findById(id);
    }
    @Override
    public void delete(Long id) {
        donationRepository.deleteDonationById(id);
    }
    @Override
    public Long countAll() {
        return donationRepository.countAll();
    }
    @Override
    public Long countBags() {
        return donationRepository.countQuantity();
    }

}
