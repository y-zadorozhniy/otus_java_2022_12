package ru.otus.homework;

import java.util.Objects;

public class Customer {

    private final long id;
    private String name;
    private long scores;

    //todo: 1. в этом классе надо исправить ошибки

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public Customer(Customer source) {
        this.id = source.id;
        this.name = source.name;
        this.scores = source.scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Customer customer = (Customer) o;

        if (id == customer.id) {
            return true;
        }

        if (scores != customer.scores) {
            return false;
        }

        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
