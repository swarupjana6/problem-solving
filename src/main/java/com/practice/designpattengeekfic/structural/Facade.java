package com.practice.designpattengeekfic.structural;

import static com.practice.designpattengeekfic.structural.WebExplorerHelperFacade.generateReports;

public class Facade {

    public static void main(String[] args) {
        String test = "CheckElementPresent";
        generateReports("firefox", "html", test);
        generateReports("firefox", "junit", test);
        generateReports("chrome", "html", test);
        generateReports("chrome", "junit", test);
    }

}

class WebExplorerHelperFacade {
    public static void generateReports(String explorer, String report, String test) {
        switch (explorer) {
            case "firefox" -> ReportGeneration.firefoxReport(report, test);
            case "chrome" -> ReportGeneration.chromeReport(report, test);
        }
    }
}

class ReportGeneration {

    public static void firefoxReport(String report, String test) {
        Driver driver = Firefox.getFirefoxDriver();
        switch (report) {
            case "html":
                Firefox.generateHTMLReport(test, driver);
                break;
            case "junit":
                Firefox.generateJUnitReport(test, driver);
                break;
        }
    }

    public static void chromeReport(String report, String test) {
        Driver driver = Chrome.getChromeDriver();
        switch (report) {
            case "html":
                Chrome.generateHTMLReport(test, driver);
                break;
            case "junit":
                Chrome.generateJUnitReport(test, driver);
                break;
        }
    }
}

record Driver(String name) {
}

class Firefox {
    public static Driver getFirefoxDriver() {
        return new Driver("FIREFOX_DRIVER");
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return new Driver("CHROME_DRIVER");
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

