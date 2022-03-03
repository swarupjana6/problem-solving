package com.practice.solid.dependencyinversion.good;

public class PrintingJob {

    public static void main(String[] args) {
        PrinterDesk dotPrintingJob = new PrinterDesk(new DotMatrixPrinter());
        dotPrintingJob.printFile();

        PrinterDesk laserPrintingJob = new PrinterDesk(new LaserPrinter());
        laserPrintingJob.printFile();
    }
}
