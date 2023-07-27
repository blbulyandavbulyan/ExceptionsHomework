package org.blbulyandavbulyan.exceptionshw.task4.bank;

import java.util.HashSet;
import java.util.Set;

public class Bank {
    private final AccountFactory accountFactory;
    private final Set<BankAccount> bankAccounts;
    public Bank(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
        bankAccounts = new HashSet<>();
    }
    public synchronized BankAccount createAccount(){
        var result = accountFactory.create();
        bankAccounts.add(result);
        return result;
    }
    public synchronized void topUpAccount(BankAccount bankAccount, long amount){
        if(bankAccounts.contains(bankAccount)) bankAccount.topUp(amount);
        else throw new IllegalArgumentException("This is not my bank account!");
    }
    public synchronized void withdrawFromAccount(BankAccount bankAccount, long amount){
        if(bankAccounts.contains(bankAccount)) bankAccount.withDraw(amount);
        else throw new IllegalArgumentException("This is not my bank account!");
    }
}
