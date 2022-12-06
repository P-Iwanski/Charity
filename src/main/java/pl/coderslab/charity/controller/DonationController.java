package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.model.*;
import pl.coderslab.charity.service.implementation.CategoryServiceImpl;
import pl.coderslab.charity.service.implementation.DonationServiceImpl;
import pl.coderslab.charity.service.implementation.InstitutionServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;
    private final CategoryServiceImpl categoryService;



    @RequestMapping(value = "/app/form", method = RequestMethod.GET)
    public String form(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        List<Institution> institutions = institutionService.getInstitutions();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categories);

        return "app/form";
    }
    @RequestMapping(value = "/app/form", method = RequestMethod.POST)
   public String save(Model model, Donation donation) {
        donationService.add(donation);
        return "form-confirmation";
   }
}
