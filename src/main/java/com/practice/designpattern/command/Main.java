package com.practice.designpattern.command;

import com.practice.designpattern.command.good.impls.AddCustomerCommand;
import com.practice.designpattern.command.good.impls.BlackAndWhiteCommand;
import com.practice.designpattern.command.good.impls.CompositeCommand;
import com.practice.designpattern.command.good.CustomerService;
import com.practice.designpattern.command.good.impls.ResizeCommand;
import com.practice.designpattern.command.good.framework.Button;

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
