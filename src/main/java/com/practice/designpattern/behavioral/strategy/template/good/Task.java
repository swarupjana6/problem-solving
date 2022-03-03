package com.practice.designpattern.behavioral.strategy.template.good;

public abstract class Task {

    private AuditTrailTask auditTrailTask;

    public Task() {
        this.auditTrailTask = new AuditTrailTask();
    }

    public Task(AuditTrailTask auditTrailTask) {
        this.auditTrailTask = auditTrailTask;
    }

    public void execute() {
        auditTrailTask.record();
        doExecute();
    }

    protected abstract void doExecute();
}
