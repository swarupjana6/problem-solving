package com.practice.designpattengeekfic.behavarioual;

import lombok.Data;
import lombok.Getter;

import java.util.List;

public class Visitor {

    public static void main(String[] args) {
        new Visitor().call();
    }

    private void call() {
        List<Client> clients = List.of(
                new Bank("bank_name", "bank_address", "bank_number", 10),
                new Resident("resident_name", "resident_address", "resident_number", "A"),
                new Company("company_name", "company_address", "company_number", 1000),
                new Restaurant("resto_name", "resto_address", "resto_number", true)
        );

        new InsuranceMessagingVisitor().sendInsuranceMails(clients);
    }
}

interface InsuranceVisitor {
    void visit(Bank bank);

    void visit(Company company);

    void visit(Resident resident);

    void visit(Restaurant restaurant);
}

class InsuranceMessagingVisitor implements InsuranceVisitor {

    public void sendInsuranceMails(List<Client> clients) {
        for (Client client : clients) {
            client.accept(this);
        }
    }

    @Override
    public void visit(Bank bank) {
        System.out.println("Sending mail about theft insurance to " + bank.getName());
    }

    public void visit(Company company) {
        System.out.println("Sending employees and equipment insurance mail to " + company.getName());
    }

    public void visit(Resident resident) {
        System.out.println("Sending mail about medical insurance to " + resident.getName());
    }

    public void visit(Restaurant restaurant) {
        System.out.println("Sending mail about fire and food insurance to " + restaurant.getName());
    }
}

@Data
abstract class Client {
    private final String name;
    private final String number;
    private final String address;

    protected abstract void accept(InsuranceVisitor visitor);
}

class Bank extends Client {
    @Getter
    private final int branchInsured;

    Bank(String name, String number, String address, int branchInsured) {
        super(name, number, address);
        this.branchInsured = branchInsured;
    }

    @Override
    protected void accept(InsuranceVisitor visitor) {
        visitor.visit(this);
    }
}

class Company extends Client {
    @Getter
    private final int noOfEmployee;

    Company(String name, String number, String address, int noOfEmployee) {
        super(name, number, address);
        this.noOfEmployee = noOfEmployee;
    }

    @Override
    protected void accept(InsuranceVisitor visitor) {
        visitor.visit(this);
    }
}

class Resident extends Client {
    @Getter
    private final String insuranceClass;

    Resident(String name, String number, String address, String insuranceClass) {
        super(name, number, address);
        this.insuranceClass = insuranceClass;
    }

    @Override
    protected void accept(InsuranceVisitor visitor) {
        visitor.visit(this);
    }
}

class Restaurant extends Client {
    @Getter
    private final boolean availableAbroad;

    Restaurant(String name, String number, String address, boolean availableAbroad) {
        super(name, number, address);
        this.availableAbroad = availableAbroad;
    }

    @Override
    protected void accept(InsuranceVisitor visitor) {
        visitor.visit(this);
    }
}
