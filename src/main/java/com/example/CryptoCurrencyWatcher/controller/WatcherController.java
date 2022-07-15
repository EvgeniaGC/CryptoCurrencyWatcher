package com.example.CryptoCurrencyWatcher.controller;

import com.example.CryptoCurrencyWatcher.model.Currency;
import com.example.CryptoCurrencyWatcher.model.User;
import com.example.CryptoCurrencyWatcher.model.UserResponse;
import com.example.CryptoCurrencyWatcher.service.CurrencyService;
import com.example.CryptoCurrencyWatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WatcherController {

    @Autowired
    private CurrencyService service;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showListCurPage(Model model) {
        service.getAllFirst10Currency();
        return "welcome";
    }

    @GetMapping("/registerUser")
    public String addUserPage(User userToCreate) {
        return "signin";
    }

    @PostMapping("/signin")
    public String signInUser(@Valid User userToCreate,
                             BindingResult result,
                             Model model) {
        UserResponse response = userService.regUser(userToCreate);
        String message = response.getMessage();
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "regResponse";
    }

    @GetMapping("/logInUser")
    public String logInUserPage(User userToLogIn) {
        return "login";
    }

    @PostMapping("/login")
    public String enterUser(@Valid User enteredUser,
                            BindingResult result,
                            Model model) {
        UserResponse response = userService.logIn(enteredUser);
        String message = response.getMessage();
        if (message != null) {
            model.addAttribute("errorMessage", message);
            return "login";
        }
        model.addAttribute("user", userService.getUserByEmail(response.getUserToCreate().getEmail()));
        return "mainPage";
    }

    @PostMapping("/showCur")
    public String showCurrency(@Valid Integer curId,
                               BindingResult result,
                               Model model) {
        service.getAllFirst10Currency();
        Currency currency = service.getCurById(curId);
//        User user = userService.getUserByEmail(email);
//        List<Currency> curOfUser = user.getListOfCurrency();
//        curOfUser.add(currency);
        model.addAttribute("currency", currency);
        return "showCurrency";
    }


}
