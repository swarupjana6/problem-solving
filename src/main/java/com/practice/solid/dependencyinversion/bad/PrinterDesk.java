package com.practice.solid.dependencyinversion.bad;

public class PrinterDesk {

    private DotMatrixPrinter printer = new DotMatrixPrinter();

    public void printFile() {
        printer.print("File Content");
    }
}