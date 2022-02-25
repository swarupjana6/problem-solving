package com.practice.solid.dependencyinversion.good;

public class DotMatrixPrinterPrinter implements Printer {

    private String inc;

    public String getInc() {
        return inc;
    }

    public void setInc(String inc) {
        this.inc = inc;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
