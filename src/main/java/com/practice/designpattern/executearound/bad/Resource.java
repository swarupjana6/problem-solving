package com.practice.designpattern.executearound.bad;

public class Resource {

    public Resource() {
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

    public void close() {
        System.out.println("Resource clean up....");
    }
}

class TestResource {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.operation1();
        resource.operation2();

        //the caller is responsible to close the resource
        resource.close();
    }
}
