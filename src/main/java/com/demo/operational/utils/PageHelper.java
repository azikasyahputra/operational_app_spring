package com.demo.operational.utils;

import org.springframework.ui.Model;

public class PageHelper {
    // This method returns the content and page title dynamically based on the page name
    public static String loadPage(Model model, String content, String pageTitle) {
        // Set the content and page title dynamically in the model
        model.addAttribute("content", content);
        model.addAttribute("pageTitle", capitalize(pageTitle));

        // Return the layout view, which includes the base template
        return "layout/layout";
    }

    // Utility method to capitalize the first letter of the page for the title
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}