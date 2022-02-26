package com.practice.designpattern.executearound.good;

import java.util.function.Consumer;

public class Resource {

    // Constructor made private
    private Resource() {
        System.out.println("Resource created");
    }

    public Resource operation1() {
        System.out.println("Resource operation 1: 1111");
        return this;
    }

    public Resource operation2() {
        System.out.println("Resource operation 2: 2222");
        return this;
    }

    // Closing made private
    private void close() {
        System.out.println("Resource clean up....");
    }

    // Introduced use method --> to close resource after using
    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}

class TestResource {
    public static void main(String[] args) {
        //Execute around method pattern
        Resource.use(resource -> resource.operation1().operation2());
    }
}
