package ru.otus.homework;


import java.util.Deque;
import java.util.LinkedList;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    private final Deque<Customer> queue = new LinkedList<>();

    public void add(Customer customer) {
        queue.add(customer);
    }

    public Customer take() {
        return queue.pollLast();
    }
}
