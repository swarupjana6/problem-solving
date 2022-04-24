package com.practice.designpattern.behavioral.strategy;

public interface Filter {
    void apply(String fileName);
}

class BlackAndWhite implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying B&W filter");
    }
}

class HighContrast implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying high-contrast filter");
    }
}
