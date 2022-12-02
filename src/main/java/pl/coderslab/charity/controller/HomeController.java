package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.implementation.DonationServiceImpl;
import pl.coderslab.charity.service.implementation.InstitutionServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;

    @RequestMapping("/")
    public String home(Model model){
        List<Institution> institutions= institutionService.getInstitutions();
        Long donates = donationService.countAll();
        Long bags = donationService.countBags();
        model.addAttribute("donates", donates);
        model.addAttribute("bags", bags);
        model.addAttribute("institutions", institutions);
        return "index";
    }
}
