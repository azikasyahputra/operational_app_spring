package com.demo.operational.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormatHelper {
    // Method to format double
    public static String formatNumber(double number) {
        return format(number); // Call the helper method to format double
    }

    // Method to format long
    public static String formatNumber(long number) {
        return format(number); // Call the helper method to format long
    }

    // Common method for formatting (handles both long and double)
    private static String format(Number number) {
        // Create DecimalFormatSymbols to customize separators
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');  // Set dot as thousands separator
        symbols.setDecimalSeparator(',');  // Set comma as decimal separator

        // Create DecimalFormat with the custom symbols
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##", symbols);

        // Format the number and return it as a string
        return decimalFormat.format(number);
    }
}
