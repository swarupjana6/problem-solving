package com.practice.designpattengeekfic.structural;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Composite {

    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();

        compositeAccount.addAccount(new DepositAccount("DA001", 100));
        compositeAccount.addAccount(new DepositAccount("DA002", 200));
        compositeAccount.addAccount(new SavingAccount("SA001", 150));

        System.out.format("Total Balance : %s\n", compositeAccount.getBalance());
    }
}

abstract class Account {
    public abstract float getBalance();
}

@AllArgsConstructor
class DepositAccount extends Account {

    private String accountNo;

    private float accountBalance;

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

@AllArgsConstructor
class SavingAccount extends Account {

    private String accountNo;

    private float accountBalance;

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {

    private float totalBalance;

    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = accountList.stream().map(Account::getBalance).reduce(0f, Float::sum);
        return totalBalance;
    }

    public void addAccount(Account acc) {
        accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        accountList.add(acc);
    }
}