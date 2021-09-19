package com.prithila.personalfinancemanagement.service;

import com.prithila.personalfinancemanagement.entity.BankAccount;
import com.prithila.personalfinancemanagement.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Prithila
 * @since 9/20/2021
 */

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public void save(BankAccount bankaccount) {
        bankAccountRepository.save(bankaccount);
    }

    @Override
    public void update(BankAccount bankaccount) {
        bankAccountRepository.update(bankaccount);
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return bankAccountRepository.findAllBankAccounts();
    }
}
