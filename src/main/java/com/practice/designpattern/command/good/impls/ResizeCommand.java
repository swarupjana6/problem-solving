package com.practice.designpattern.command.good.impls;

import com.practice.designpattern.command.good.framework.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
