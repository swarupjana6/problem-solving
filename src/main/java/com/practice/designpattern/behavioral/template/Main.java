package com.practice.designpattern.behavioral.template;

import com.practice.designpattern.behavioral.template.good.task.TransferMoneyTask;

public class Main {

    public static void main(String[] args) {
        // Transfer Money
        // Generate Report
        var task = new TransferMoneyTask();
        task.execute();
    }
}
