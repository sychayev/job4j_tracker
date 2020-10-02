package ru.job4j.tracker;

public class Plane implements Vehicle{

    @Override
    public void move(){
        System.out.println( "I can fly!!");
    }
}
