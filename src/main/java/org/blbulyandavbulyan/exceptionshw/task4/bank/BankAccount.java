package org.blbulyandavbulyan.exceptionshw.task4.bank;

import org.blbulyandavbulyan.exceptionshw.task4.bank.exceptions.InsufficientFundsException;
import org.blbulyandavbulyan.exceptionshw.task4.bank.exceptions.MaxBalanceExceededException;

/**
 * Предоставляет счёт в банке
 */
public class BankAccount {
    private long balance;
    private final long maxBalance;

    public BankAccount(long balance, long maxBalance) {
        this.balance = balance;
        this.maxBalance = maxBalance;
    }
    public long getBalance() {
        return balance;
    }

    public long getMaxBalance() {
        return maxBalance;
    }

    /**
     * Снятие денег со счёта
     * @param amount сумма которую нужно снять
     */
    void withDraw(long amount){
        if(amount > balance) throw new InsufficientFundsException();
        balance -=amount;
    }

    /**
     * Метод пополнения счёта
     * @param amount сумма, на которую нужно пополнить счёт
     */
    void topUp(long amount){
        if(amount > maxBalance) throw new MaxBalanceExceededException();
        balance +=amount;
    }
}
