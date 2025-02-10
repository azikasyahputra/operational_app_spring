package com.demo.operational.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpSession session) {
        Object userId = session.getAttribute("id");
        if (userId == null) {
            return "redirect:/login";
        }
        return "redirect:/dashboard";
    }
}
