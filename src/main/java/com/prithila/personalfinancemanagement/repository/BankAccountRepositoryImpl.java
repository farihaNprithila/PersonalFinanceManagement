package com.prithila.personalfinancemanagement.repository;

import com.prithila.personalfinancemanagement.entity.Account;
import com.prithila.personalfinancemanagement.entity.BankAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Prithila
 * @since 9/20/2021
 */

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(BankAccount bankaccount) {
        Query query = entityManager.createQuery("Select a.balance from Account a where a.accountNumber= :accountNo");
        query.setParameter("accountNo", bankaccount.getAccountNumber());
        List<Long> accountBalance = query.getResultList();
        if (!accountBalance.isEmpty()) {
            Long balance = accountBalance.get(0);
            if ("Debit".equalsIgnoreCase(bankaccount.getTransactionType())) {
                Long newBalance = balance + bankaccount.getAmount();

                bankaccount.setAmount(newBalance);
                entityManager.persist(bankaccount);
                entityManager.flush();

                Account account = new Account(bankaccount.getAccountNumber(), newBalance);
                entityManager.merge(account);
                entityManager.flush();

            } else if ("Credit".equalsIgnoreCase(bankaccount.getTransactionType())) {
                Long newBalance = balance - bankaccount.getAmount();

                bankaccount.setAmount(newBalance);
                entityManager.persist(bankaccount);
                entityManager.flush();

                Account account = new Account(bankaccount.getAccountNumber(), newBalance);
                entityManager.merge(account);
                entityManager.flush();
            }

        } else {
            Account newAccount = new Account(bankaccount.getAccountNumber(), 0L);

            if ("Debit".equalsIgnoreCase(bankaccount.getTransactionType())) {
                entityManager.persist(newAccount);
                entityManager.flush();

                bankaccount.setAmount(0l + bankaccount.getAmount());

            } else if ("Credit".equalsIgnoreCase(bankaccount.getTransactionType())) {
                entityManager.persist(newAccount);
                entityManager.flush();

                bankaccount.setAmount(0l - bankaccount.getAmount());
            }
        }
    }

    @Override
    public void update(BankAccount bankaccount) {
        /*will be implemented in future*/
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        Query query = entityManager.createQuery("Select b from BankAccount b");
        List<BankAccount> bankAccountList = query.getResultList();
        return bankAccountList;
    }

}
