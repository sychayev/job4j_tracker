package ru.job4j.tracker;


public class StartUI extends  Tracker{

    public static void main(String[] args) {
        Item i = new Item();
        Tracker track = new Tracker();
        track.add(i);
        System.out.println(track.findById(3));


    }
}

