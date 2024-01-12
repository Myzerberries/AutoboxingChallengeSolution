package dev.lpa;

import java.util.ArrayList;

record Customer1(String name, ArrayList<Double> transactions){

    public Customer1(String name, double initialDeposit){

        this(name.toUpperCase(), new ArrayList<>(500));
        transactions.add(initialDeposit);

    }

}

public class Solution {

    public static void main(String[] args) {

        Customer1 bob = new Customer1("Bob S", 1000.0);
        System.out.println(bob);

        Bank1 bank = new Bank1("Chase");
        bank.addNewCustomer("Jane A", 500.0);
        System.out.println(bank);

    }

}

class Bank1 {

    private String name;
    private ArrayList<Customer1> customers = new ArrayList<>(5000);

    public Bank1(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank1{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer1 getCustomer(String customerName){

        for(var customer: customers){
            if(customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }

        System.out.printf("Customer (%s) wasn't found %n", customerName);

        return null;

    }

    public void addNewCustomer(String customerName, double initialDeposit){

        if(getCustomer(customerName) == null){
            Customer1 customer = new Customer1(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New Customer added: " + customer);
        }

    }

    public void addTransaction(String name, double transactionAmount){

        Customer1 customer = getCustomer(name);
        if(customer != null){
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName){

        Customer1 customer = getCustomer(customerName);
        if(customer == null){
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customer.name());
        System.out.println("Transactions:");
        for(double d : customer.transactions()) {
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}