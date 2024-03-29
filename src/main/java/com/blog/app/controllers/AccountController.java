package com.blog.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blog.app.forms.LoginForm;
import com.blog.app.services.LoginService;
import com.blog.app.services.NotificationService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class AccountController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/users/login")
    public String showLoginForm(LoginForm loginForm) {
        return "/users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String showLoginForm( @Valid LoginForm loginForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage(
                    "invalid details please enter the username and password correctly!");
            return "/users/login";
        }

        if (! loginService.authentice(loginForm.getUsername(),
                loginForm.getPassword())) {
            notificationService.addErrorMessage("Invalid login");
            return "/users/login";
        }
        else {
        // Login successful
        notificationService.addInfoMessage("login successfull!");
        return "redirect:/data";
        }
    }
}
