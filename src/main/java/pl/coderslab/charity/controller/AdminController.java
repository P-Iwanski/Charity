package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.*;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping(value = "/admin/editOrg")
    public String editInstitution(Institution institution, Model model) {
        model.addAttribute("institution", institutionService.get(institution.getId()).get());
        institutionService.delete(institution.getId());
        return "/admin/editOrg";
    }
    @PostMapping(value = "/admin/editOrg")
    public String editInst(@Valid InstitutionDTO institutionDTO, BindingResult result){
       if (!result.hasErrors()){
           institutionService.updateEdit(institutionDTO);
           return "index";
       }
       return "index";
    }
    @GetMapping(value = "/admin/deleteOrg")
    public String deleteInstitution(Institution institution, Model model) {
        model.addAttribute("institution", institutionService.get(institution.getId()).get());
        institutionService.delete(institution.getId());
        return "/index";
    }
    @GetMapping(value = "/admin/createOrg")
    public String createInstitution(Institution institution, Model model) {
        model.addAttribute("institution", institution);
        return "/admin/createOrg";
    }
    @PostMapping(value = "/admin/createOrg")
    public String createInst(@Valid InstitutionDTO institutionDTO, BindingResult result){
        if (!result.hasErrors()){
            institutionService.add(institutionDTO);
            return "/admin/organization";
        }
        return "/admin/organization";
    }
    @GetMapping(value = "/admin/organization")
    public String institutionList(Model model) {
        List<Institution> institutions= institutionService.getInstitutions();
        List<User> users = userService.findAll();
        model.addAttribute("institutions", institutions);
        model.addAttribute("users", users);
        return "/admin/organization";
    }

    @GetMapping(value = "/admin/editUser")
    public String editUser(User user, Model model) {
        model.addAttribute("user", userService.get(user.getId()).get());
        return "/admin/editUser";
    }
    @PostMapping(value = "/admin/editUser")
    public String editUser(@Valid User user, BindingResult result){
        if (!result.hasErrors()){
            userService.update(user);
            return "/admin/organization";
        }
        return "admin/editUser";
    }
    @GetMapping(value = "/admin/deleteUser")
    public String deleteUser(User user, Model model) {
        model.addAttribute("user", userService.get(user.getId()).get());
        userService.delete(user.getId());
        return "/admin/organization";
    }
    @RequestMapping(value = "/app/account", method = RequestMethod.GET)
    public String editUserByUser(User user, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userService.get(currentUser.getUser().getId()));
        return "/app/account";
    }
    @RequestMapping(value = "/app/account", method = RequestMethod.POST)
    public String editUserByUser(@Valid User user, BindingResult result){
        if (!result.hasErrors()){
            userService.update(user);
            return "/index";
        }
        return "admin/editUser";
    }
}
