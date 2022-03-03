package com.practice.designpattern.behavioral.strategy.template;

import com.practice.designpattern.behavioral.strategy.template.good.task.TransferMoneyTask;

public class Main {

    public static void main(String[] args) {
        // Transfer Money
        // Generate Report
        var task = new TransferMoneyTask();
        task.execute();
    }
}
