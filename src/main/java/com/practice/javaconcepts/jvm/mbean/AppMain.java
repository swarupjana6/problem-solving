package com.practice.javaconcepts.jvm.mbean;

import io.hawt.embedded.Main;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

import static com.practice.javaconcepts.jvm.mbean.ConsoleApp.startConsoleApp;

public class AppMain {

    public static void main(String[] args) throws Exception {
        // STEP 1:: Start Hawtio WAR to access MBean objects attributes via HTTP endpoint. (Note: The MBean can also be accessed by JConsole, JDK Mission Control etc.)
        runHawtio();

        // STEP 2:: Create MBean object that you need to monitor for our case it is Calculator
        Calculator c1 = new Calculator();

        // STEP 3:: Register Calculator object with JMX Agent so that it can be monitored
        registerWithJmxAgent(c1);

        // STEP 4:: Start console application to use the Calculation object
        startConsoleApp(c1);
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
