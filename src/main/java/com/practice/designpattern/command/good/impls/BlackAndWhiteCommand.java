package com.practice.designpattern.command.good.impls;

import com.practice.designpattern.command.good.framework.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Black and White");
    }
}
