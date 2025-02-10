package com.demo.operational.controller;

import com.demo.operational.model.User;
import com.demo.operational.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(HttpSession session) {
        Object userId = session.getAttribute("id");
        if (userId != null) {
            return "redirect:/dashboard";
        }

        return "login/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashedPassword = DigestUtils.sha256Hex(password);  // Assuming SHA-256 hashing.

        User user = userService.findByUsernameAndPassword(username, hashedPassword);

        if (user != null) {
            System.out.println("Berhasil Login");
            session.setAttribute("id", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("nama", user.getNama());
            session.setAttribute("role", user.getRole());
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

