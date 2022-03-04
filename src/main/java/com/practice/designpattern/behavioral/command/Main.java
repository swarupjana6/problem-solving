package com.practice.designpattern.behavioral.command;

import com.practice.designpattern.behavioral.command.good.framework.Button;
import com.practice.designpattern.behavioral.command.good.impls.AddCustomerCommand;
import com.practice.designpattern.behavioral.command.good.impls.BlackAndWhiteCommand;
import com.practice.designpattern.behavioral.command.good.impls.CompositeCommand;
import com.practice.designpattern.behavioral.command.good.CustomerService;
import com.practice.designpattern.behavioral.command.good.impls.ResizeCommand;

public class Main {

    public static void main(String[] args) {
        simpleCommand();
        compositeCommand();
    }

    private static void compositeCommand() {
        var composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        composite.add(new BlackAndWhiteCommand());
        composite.execute();
    }

    private static void simpleCommand() {
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}
