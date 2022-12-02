package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Donation;

import java.util.List;
import java.util.Optional;

public interface DonationService {
    void add(Donation donation);
    List<Donation> getDonations();
    Optional<Donation> get(Long id);
    void delete(Long id);
    Long countAll();
    Long countBags();

}
