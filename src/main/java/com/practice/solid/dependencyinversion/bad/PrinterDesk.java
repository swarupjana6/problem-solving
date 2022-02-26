package com.practice.solid.dependencyinversion.bad;

public class PrinterDesk {

    private DotMatrixPrinter printer;

    public PrinterDesk(DotMatrixPrinter printer) {
        this.printer = printer;
    }

    public void printFile() {
        printer.print("File Content");
    }

}