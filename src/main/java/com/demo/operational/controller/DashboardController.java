package com.demo.operational.controller;

import com.demo.operational.service.BukuKasDetailService;
import com.demo.operational.service.InvoiceService;
import com.demo.operational.service.OrderService;
import com.demo.operational.service.PengeluaranDetailService;
import com.demo.operational.utils.NumberFormatHelper;
import com.demo.operational.utils.PageHelper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private PengeluaranDetailService pengeluaranDetailService;

    @Autowired
    private BukuKasDetailService bukuKasDetailService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        long ordersToday = orderService.getOrdersToday();
        long ordersThisMonth = orderService.getOrdersThisMonth();
        long invoicesToday = invoiceService.getInvoicesToday();
        long invoicesThisMonth = invoiceService.getInvoicesThisMonth();

        double labaMonth = pengeluaranDetailService.calculatePengeluaranThisMonth() - invoiceService.calculateLabaMonth();
        double labaToday = pengeluaranDetailService.calculatePengeluaranToday() - invoiceService.calculateLabaToday();
        double incomeMonth = bukuKasDetailService.calculateTotalIncome();
        double expenseMonth = bukuKasDetailService.calculateTotalExpense();
        double labaBrutoMonth = incomeMonth - expenseMonth;

        String formattedOrdersToday = NumberFormatHelper.formatNumber(ordersToday);
        String formattedOrdersThisMonth = NumberFormatHelper.formatNumber(ordersThisMonth);
        String formattedInvoicesToday = NumberFormatHelper.formatNumber(invoicesToday);
        String formattedInvoicesThisMonth = NumberFormatHelper.formatNumber(invoicesThisMonth);
        String formattedLabaMonth = NumberFormatHelper.formatNumber(labaMonth);
        String formattedLabaToday = NumberFormatHelper.formatNumber(labaToday);
        String formattedIncomeMonth = NumberFormatHelper.formatNumber(incomeMonth);
        String formattedExpenseMonth = NumberFormatHelper.formatNumber(expenseMonth);
        String formattedLabaBrutoMonth = NumberFormatHelper.formatNumber(labaBrutoMonth);

        model.addAttribute("ordersToday", formattedOrdersToday);
        model.addAttribute("ordersThisMonth", formattedOrdersThisMonth);
        model.addAttribute("invoicesToday", formattedInvoicesToday);
        model.addAttribute("invoicesThisMonth", formattedInvoicesThisMonth);
        model.addAttribute("labaMonth", formattedLabaMonth);
        model.addAttribute("labaToday", formattedLabaToday);
        model.addAttribute("expenseMonth", formattedExpenseMonth);
        model.addAttribute("incomeMonth", formattedIncomeMonth);
        model.addAttribute("labaBrutoMonth", formattedLabaBrutoMonth);

        return PageHelper.loadPage(model, "dashboard/index", "dashboard");
    }
}
