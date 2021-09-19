package com.prithila.personalfinancemanagement.controller;

import com.prithila.personalfinancemanagement.entity.BankAccount;
import com.prithila.personalfinancemanagement.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Prithila
 * @since 9/20/2021
 */

@Controller
public class BankTransactionController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/banktransaction")
    public String bankTransaction(Model model) {
        List<BankAccount> getTransactions = bankAccountService.findAllBankAccounts();
        model.addAttribute("banktransaction", getTransactions);
        return "/banktransaction";
    }

    @GetMapping("/addtransaction")
    public String addCourse(Model model) {
        model.addAttribute("addtransaction", new BankAccount());
        return "addtransaction";
    }

    @PostMapping("/addtransaction")
    public String addTransaction(@RequestParam("task") String task, @Valid @ModelAttribute("addtransaction") BankAccount bankAccount, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        bankAccountService.save(bankAccount);
        return "redirect:/banktransaction";
    }
}
