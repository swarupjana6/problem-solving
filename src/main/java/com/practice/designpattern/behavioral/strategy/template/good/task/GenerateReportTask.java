package com.practice.designpattern.behavioral.strategy.template.good.task;

import com.practice.designpattern.behavioral.strategy.template.good.Task;

public class GenerateReportTask extends Task {

    @Override
    protected void doExecute() {
        System.out.println("Generate Report");
    }
}
