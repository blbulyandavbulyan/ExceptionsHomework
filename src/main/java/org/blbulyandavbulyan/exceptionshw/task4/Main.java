package org.blbulyandavbulyan.exceptionshw.task4;

import org.blbulyandavbulyan.exceptionshw.task4.bank.Bank;
import org.blbulyandavbulyan.exceptionshw.task4.bank.BankAccount;
import org.blbulyandavbulyan.exceptionshw.task4.bank.exceptions.InsufficientFundsException;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(()-> new BankAccount(0, 1000));
        //здесь я работаю с одним аккаунтом из разных потоков для наглядности
        var account = bank.createAccount();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread topUpperThread = new Thread(()->{
            countDownLatch.countDown();
            try {
                countDownLatch.await();
                for (int i = 0; i < 10; i++) {
                    bank.topUpAccount(account, 100);
                    System.out.println("Счёт пополнился на 100");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread withdrawerThread = new Thread(()->{
            countDownLatch.countDown();
            try {
                countDownLatch.await();
                for(int i = 0; i < 5;){
                    try {
                        bank.withdrawFromAccount(account, 100);
                        System.out.println("Сняли 100 денег со счёта");
                        i++;
                    }
                    catch (InsufficientFundsException e){
                        System.out.println("На счёте было недостаточно денег для снятия");
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        topUpperThread.start();
        withdrawerThread.start();
        countDownLatch.countDown();
        topUpperThread.join();
        withdrawerThread.join();
        //проверяем баланс
        System.out.printf("Баланс: %d", account.getBalance());
    }
}
