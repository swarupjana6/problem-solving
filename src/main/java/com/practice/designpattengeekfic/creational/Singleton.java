package com.practice.designpattengeekfic.creational;

public class Singleton {

    public static void main(String[] args) {
        SingletonLazyAndThreadSafe singletonLazyAndThreadSafe = SingletonLazyAndThreadSafe.getInstance();
    }
}

class SingletonLazyAndThreadSafe {

    // This is made VOLATILE "a shared variable stored in memory can reference a partially constructed object"
    // Instance might not be null even though the initialization is not yet done
    private static volatile SingletonLazyAndThreadSafe instance;
    private String data;

    private SingletonLazyAndThreadSafe(String data) {
        this.data = data;
    }
    public static synchronized SingletonLazyAndThreadSafe getInstance() {
        // This is done to avoid direct reads from the memory, improves method overall performance by 40%
        SingletonLazyAndThreadSafe result = instance;
        if (result == null) {
            synchronized (SingletonLazyAndThreadSafe.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SingletonLazyAndThreadSafe("init-data");
                }
            }
        }
        return result;
    }
}
