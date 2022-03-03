package com.practice.designpattern.behavioral.strategy.template.bad;

public class GenerateReportTask {

    private AuditTrailTask auditTrailTask;

    public GenerateReportTask(AuditTrailTask auditTrailTask) {
        this.auditTrailTask = auditTrailTask;
    }

    public void execute() {
        auditTrailTask.record();
        System.out.println("Generate Report");
    }
}
