package com.demo.operational.controller;

import com.demo.operational.enums.QueryOperator;
import com.demo.operational.model.User;
import com.demo.operational.service.UserService;
import com.demo.operational.utils.PageHelper;
import com.demo.operational.validation.CreateGroup;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends CrudController<User> {
    @Autowired
    private UserService userService;

    @Override
    protected String getEntityPath() {
        return "user";  // Specify the unique path for the User entity
    }

    @Override
    protected String getViewPath() {
        return "master-input/user";
    }

    @Override
    protected String getEntityName() {
        return "User";
    }

    @Override
    protected User getNewEntity() {
        return new User();
    }

    @Override
    protected String getEntityNameLower() {
        return "user";
    }

    @PostMapping("/create")
    @Override
    public String saveData(@Validated(CreateGroup.class) @ModelAttribute User user,
                           BindingResult result,
                           Model model) {
        // Check if passwords match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.user", "Passwords do not match.");
        }

        if (result.hasErrors()) {
            return PageHelper.loadPage(model, getViewPath() + "/create", "Create " + getEntityName());
        }

        String hashedPassword = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(hashedPassword);

        // Save the user (to be implemented in your service)
        userService.saveData(user);  // Assuming you have a userService to save the user
        return "redirect:/" + getEntityPath() + "/list";
    }

    @Override
    protected List<String> getSelectableFields() {
        return Arrays.asList("id", "username", "nama", "email", "role");
    }

    @Override
    protected Map<String, QueryOperator> getWhereFields() {
        Map<String, QueryOperator> fields = new HashMap<>();
        fields.put("username", QueryOperator.LIKE);
        fields.put("nama", QueryOperator.LIKE);
        fields.put("email", QueryOperator.LIKE);
        fields.put("role", QueryOperator.LIKE);
        return fields;
    }

    @Override
    protected List<String> getGroupByFields() {
        return List.of();
    }

    @Override
    protected String getSortField(){
        return "id";
    };

    @Override
    protected boolean isSortAscending(){
        return false;
    };
}