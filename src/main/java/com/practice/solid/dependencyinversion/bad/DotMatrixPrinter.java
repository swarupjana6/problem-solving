package com.practice.solid.dependencyinversion.bad;

public class DotMatrixPrinter {

    private String inc;

    public String getInc() {
        return inc;
    }

    public void setInc(String inc) {
        this.inc = inc;
    }

    public void print(String text) {
        System.out.println(text);
    }
}
