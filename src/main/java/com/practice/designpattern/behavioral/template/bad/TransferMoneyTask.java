package com.practice.designpattern.behavioral.template.bad;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransferMoneyTask {

    @NonNull
    private AuditTrailTask auditTrailTask;

    public void execute() {
        auditTrailTask.record();
        System.out.println("Transfer Money");
    }
}
