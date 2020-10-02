package ru.job4j.tracker;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("I have steel wheels!");
    }
}
