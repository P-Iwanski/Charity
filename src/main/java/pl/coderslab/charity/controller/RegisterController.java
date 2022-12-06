package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.model.RegisterDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.implementation.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class RegisterController {
    private final UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("registerDTO") RegisterDTO registerDto, BindingResult result) {
        User user = null;

        if (!result.hasErrors()) {
            user = userService.registerUser(registerDto);

            if (user != null) {
                return "redirect:login";
            }
        }
        return "register";

    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, User user) {
        model.addAttribute("user", user);
        return "login";
    }
    @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
    public String users(Model model) {
        List<User> usersList = userService.findAll();
        model.addAttribute("users", usersList);
        return "userList";
    }
    //Soft Delete
}
