package com.practice.designpattengeekfic.structural;

public class Proxy {

    public static void main(String[] args) {
        DatabaseExecutor nonAdminExecutor = new DatabaseExecutorProxy("NonAdmin", "Admin@123");
        nonAdminExecutor.execute("DELETE");

        DatabaseExecutor adminExecutor = new DatabaseExecutorProxy("Admin", "Admin@123");
        adminExecutor.execute("DELETE");
    }
}

interface DatabaseExecutor {
    public void execute(String query) throws RuntimeException;
}

class DatabaseExecutorImpl implements DatabaseExecutor {
    @Override
    public void execute(String query) throws RuntimeException {
        System.out.format("Executing query %s ...\n", query);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {

    boolean ifAdmin;
    DatabaseExecutorImpl dbExecutor;

    public DatabaseExecutorProxy(String name, String passwd) {
        if (name == "Admin" && passwd == "Admin@123") ifAdmin = true;
        dbExecutor = new DatabaseExecutorImpl();
    }

    @Override
    public void execute(String query) throws RuntimeException {
        if (ifAdmin) {
            dbExecutor.execute(query);
        } else {
            if (query.equals("DELETE")) throw new RuntimeException("DELETE not allowed for non-admin user");
            else dbExecutor.execute(query);
        }
    }
}
