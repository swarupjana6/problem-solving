package com.practice.designpattern.behavioral.strategy.template.good.task;

import com.practice.designpattern.behavioral.strategy.template.good.Task;

public class TransferMoneyTask extends Task {

    @Override
    protected void doExecute() {
        System.out.println("Transfer Money");
    }
}
