package dev.lpa;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer fred = new Customer("Fred");

        fred.transaction(12.48);
        fred.transaction(-5.12);
        fred.transaction(-28.52);
        fred.transaction(59.83);

        Customer joe = new Customer("Joe");

        joe.transaction(8.32);
        joe.transaction(9.99);
        joe.transaction(-58.83);
        joe.transaction(325.52);

        Bank usBank = new Bank("US Bank");

        usBank.addCustomer(fred);
        usBank.addCustomer(joe);

        usBank.printCustomerTransactions(fred);

    }

}

class Customer{

    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions(){
        return transactions;
    }

    public String getName(){
        return name;
    }

    public void transaction(Double amount){
        transactions.add(amount);
    }

}

class Bank {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){

        if(!customers.contains(customer)) {
            customers.add(customer);
        }

    }

    public void addTransaction(Customer customer, double amount){

        if(customers.contains(customer)) {
            customer.transaction(amount);
        }

    }

    public void printCustomerTransactions(Customer customer){

        System.out.println(customer.getName());
        System.out.println(customer.getTransactions());

    }

}
