package com.practice.designpattengeekfic.creational;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        new ChainOfResponsibility().call();
    }

    private void call() {
        Database database = new Database();
        Handler handler = new UserExistsHandler(database)
                .setNextHandler(new ValidPasswordHandler(database))
                .setNextHandler(new RoleCheckerHandler());
        AuthService authService = new AuthService(handler);
        authService.logIn("username", "password");
    }
}

class AuthService {

    private final Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean logIn(String email, String password) {
        if (handler.handle(email, password)) {
            System.out.println("Authorization was successful!");
            // Do stuff for authorized users
            return true;
        }
        return false;
    }

}

abstract class Handler {

    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String username, String password);

    public boolean handleNext(String username, String password) {
        if (next == null) return true;
        return next.handle(username, password);
    }
}

@AllArgsConstructor
class UserExistsHandler extends Handler {

    private Database database;

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidUser(username)) {
            System.out.format("User %s is not registered !\n", username);
            System.out.println("Sign up now!");
            return false;
        }
        return handleNext(username, password);
    }
}

@AllArgsConstructor
class ValidPasswordHandler extends Handler {

    private Database database;

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidPassword(username, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return handleNext(username, password);
    }
}

class RoleCheckerHandler extends Handler {

    @Override
    public boolean handle(String username, String password) {
        if ("admin_username".equals(username)) {
            System.out.println("Loading Admin page...");
            return true;
        }
        System.out.println("Loading default page...");
        return handleNext(username, password);
    }
}

class Database {

    private final Map<String, String> users;

    public Database() {
        users = new HashMap<>();
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }

    public boolean isValidUser(String username) {
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }
}
