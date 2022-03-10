package com.practice.javaconcepts.jvm.mbean;

import io.hawt.embedded.Main;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

import static com.practice.javaconcepts.jvm.mbean.ConsoleApp.startConsoleApp;

public class AppMain {

    public static void main(String[] args) throws Exception {
        runHawtio();
        Calculator calculator = new Calculator();
        registerWithJmxAgent(calculator);
        startConsoleApp(calculator);
    }

    private static void runHawtio() throws Exception {
        System.setProperty("hawtio.authenticationEnabled", "false");
        Main main = new Main();
        main.setWar(AppMain.class.getClassLoader().getResource("hawtio-war.war").getPath());
        main.run();
    }

    private static void registerWithJmxAgent(Calculator calculator) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.practice.javaconcepts.jvm.mbean:type=calculator");
        mbs.registerMBean(calculator, name);
    }
}
