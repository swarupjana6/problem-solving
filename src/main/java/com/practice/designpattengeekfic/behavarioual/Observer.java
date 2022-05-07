package com.practice.designpattengeekfic.behavarioual;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.practice.designpattengeekfic.behavarioual.Event.NEW_ITEM;
import static com.practice.designpattengeekfic.behavarioual.Event.SALE;

public class Observer {

    public static void main(String[] args) {
        new Observer().call();
    }

    private void call() {
        Store store = new Store();
        store.getService().subscribe(NEW_ITEM, new EmailMsgListener("geekific@like.com"));
        store.getService().subscribe(SALE, new EmailMsgListener("geekific@like.com"));
        store.getService().subscribe(SALE, new EmailMsgListener("geekific@subs.com"));
        store.getService().subscribe(NEW_ITEM, new MobileAppListener("GeekificLnS"));

        store.newItemPromotion();

        System.out.println("===============================================================");

        store.salePromotion();

        System.out.println("===============================================================");

        store.getService().unsubscribe(SALE, new EmailMsgListener("geekific@like.com"));
        store.salePromotion();
    }
}

class Store {

    @Getter
    private final NotificationService service;

    public Store() {
        service = new NotificationService();
    }

    public void newItemPromotion() {
        service.notifyCustomers(NEW_ITEM);
    }

    public void salePromotion() {
        service.notifyCustomers(SALE);
    }
}

class NotificationService {

    private final Map<Event, List<EventListener>> customers;

    public NotificationService() {
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event eventType, EventListener listener) {
        customers.get(eventType).add(listener);
    }

    public void unsubscribe(Event eventType, EventListener listener) {
        customers.get(eventType).remove(listener);
    }

    public void notifyCustomers(Event eventType) {
        customers.get(eventType).forEach(listener -> listener.update(eventType));
    }
}

enum Event {
    NEW_ITEM,
    SALE
}

interface EventListener {
    void update(Event eventType);
}

record EmailMsgListener(String email) implements EventListener {
    @Override
    public void update(Event eventType) {
        System.out.println("Sending mail to " + email + " concerning " + eventType);
    }
}

record MobileAppListener(String username) implements EventListener {
    @Override
    public void update(Event eventType) {
        System.out.println("Sending notification to " + username + " concerning " + eventType);
    }
}