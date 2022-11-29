package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;



    @GetMapping("/form")
    public String form(Model model) {
        List<Institution> institutions = institutionService.getInstitutions();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categories);

        return "form";
    }
   @PostMapping("/form")
   public String save(Model model, Donation donation) {
        donationService.add(donation);
        return "index";
   }
}
