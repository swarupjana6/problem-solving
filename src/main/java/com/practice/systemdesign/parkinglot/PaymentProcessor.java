package com.practice.systemdesign.parkinglot;

public abstract class PaymentProcessor {

    abstract void processPayment(double amount);

}

class PaymentProcessorCash extends PaymentProcessor {
    @Override
    void processPayment(double amount) {

    }
}


class PaymentProcessorCreditCard extends PaymentProcessor {
    @Override
    void processPayment(double amount) {

    }
}


