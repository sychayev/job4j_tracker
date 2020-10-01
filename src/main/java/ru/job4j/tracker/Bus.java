package ru.job4j.tracker;

public class Bus implements Vehicle {

    @Override
    public void pass() {
        System.out.println("I move with a many passengers!!");
    }
}
