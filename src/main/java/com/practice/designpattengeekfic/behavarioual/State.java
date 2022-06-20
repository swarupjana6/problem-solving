package com.practice.designpattengeekfic.behavarioual;

import lombok.AllArgsConstructor;
import lombok.Setter;

public class State {

    public static void main(String[] args) {
        new State().call();
    }

    private void call() {
        Phone phone = new Phone();
        System.out.println(phone.clickPower());
        System.out.println(phone.clickPower());
        System.out.println(phone.clickHome());
        System.out.println(phone.clickHome());
        System.out.println(phone.clickHome());
        System.out.println(phone.clickPower());
        System.out.println(phone.clickPower());
        System.out.println(phone.clickHome());
    }
}

class Phone {

    @Setter
    private PhoneState state;

    public Phone() {
        this.state = new OffState(this);
    }

    public String lock() {
        return "Locking phone and turning off the screen";
    }

    public String home() {
        return "Going to home-screen";
    }

    public String unlock() {
        return "Unlocking the phone to home";
    }

    public String turnOn() {
        return "Turning screen on, device still locked";
    }

    public String clickHome() {
        return state.onHome();
    }

    public String clickPower() {
        return state.onOff();
    }
}

@AllArgsConstructor
abstract class PhoneState {

    protected Phone phone;

    public abstract String onHome();

    public abstract String onOff();
}


class OffState extends PhoneState {

    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new LockState(phone));
        return phone.turnOn();
    }

    @Override
    public String onOff() {
        phone.setState(new LockState(phone));
        return phone.turnOn();
    }
}

class LockState extends PhoneState {

    public LockState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }

    @Override
    public String onOff() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}

class ReadyState extends PhoneState {

    public ReadyState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        return phone.home();
    }

    @Override
    public String onOff() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
