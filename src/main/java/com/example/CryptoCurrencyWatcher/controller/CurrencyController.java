package com.example.CryptoCurrencyWatcher.controller;

import com.example.CryptoCurrencyWatcher.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @GetMapping("/")
    public String showListCurPage(Model model) {
//        service.saveCurrency();
        model.addAttribute("currencies", service.getAllCurrencyList());
        return "listCur";
    }


//    @PostMapping("/listCur")
//    public String signInUser(@Valid User userToCreate,
//                             BindingResult result,
//                             Model model) {
//        UserBeanResponse response = service.regUser(userToCreate);
//        String message = response.getMessage();
//        if (message != null) {
//            model.addAttribute("message", message);
//        }
//        return "regResponse";
//    }

}
