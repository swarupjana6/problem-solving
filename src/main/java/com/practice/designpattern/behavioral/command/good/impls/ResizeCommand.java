package com.practice.designpattern.behavioral.command.good.impls;

import com.practice.designpattern.behavioral.command.good.framework.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
