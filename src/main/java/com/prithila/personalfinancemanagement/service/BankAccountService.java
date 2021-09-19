package com.prithila.personalfinancemanagement.service;

import com.prithila.personalfinancemanagement.entity.BankAccount;

import java.util.List;

/**
 * @author Prithila
 * @since 9/20/2021
 */

public interface BankAccountService {

    void save(BankAccount bankaccount);

    void update(BankAccount bankaccount);

    List<BankAccount> findAllBankAccounts();
}
