package com.owl.awesomeblogspot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @GetMapping(value = {"", "/"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "communication";
    }

    @GetMapping("/isAuthenticated")
    @ResponseBody
    public Boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    }

}
