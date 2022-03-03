package com.practice.designpattern.behavioral.strategy.template.bad;

import com.practice.designpattern.behavioral.strategy.template.bad.AuditTrailTask;

public class TransferMoneyTask {

    private AuditTrailTask auditTrailTask;

    public TransferMoneyTask(AuditTrailTask auditTrailTask) {
        this.auditTrailTask = auditTrailTask;
    }

    public void execute() {
        auditTrailTask.record();
        System.out.println("Transfer Money");
    }
}
