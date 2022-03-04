package com.practice.designpattern.behavioral.template.good;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Task {

    @NonNull
    private AuditTrailTask auditTrailTask;

    public Task() {
        this.auditTrailTask = new AuditTrailTask();
    }

    public void execute() {
        auditTrailTask.record();
        doExecute();
    }

    protected abstract void doExecute();
}
