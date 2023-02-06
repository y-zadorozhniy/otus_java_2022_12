package ru.otus.homework;


import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    private final TreeMap<Customer, String> customers = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> smallest = customers.firstEntry();
        return new AbstractMap.SimpleEntry<>(new Customer(smallest.getKey()), smallest.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> higherEntry = customers.higherEntry(customer);
        return higherEntry != null
                ? new AbstractMap.SimpleEntry<>(new Customer(higherEntry.getKey()), higherEntry.getValue())
                : null;
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }
}
