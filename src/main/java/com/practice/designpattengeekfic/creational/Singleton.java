package com.practice.designpattengeekfic.creational;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Singleton {

    public static void main(String[] args) {
        SingletonLazyAndThreadSafe singletonLazyAndThreadSafe = SingletonLazyAndThreadSafe.getInstance();
    }
}

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class SingletonLazyAndThreadSafe {

    // This is made VOLATILE "a shared variable stored in memory can reference a partially constructed object"
    // Instance might not be null even though the initialization is not yet done
    private static volatile SingletonLazyAndThreadSafe instance;

    public static synchronized SingletonLazyAndThreadSafe getInstance() {
        // This is done to avoid direct reads from the memory, improves method overall performance by 40%
        SingletonLazyAndThreadSafe result = instance;
        if (result == null) {
            synchronized (SingletonLazyAndThreadSafe.class) {
                result = instance;
                if (result == null) result = new SingletonLazyAndThreadSafe();
            }
        }
        return result;
    }
}
