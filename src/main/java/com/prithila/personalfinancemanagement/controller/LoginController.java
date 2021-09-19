package com.prithila.personalfinancemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Prithila
 * @since 9/19/2021
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
