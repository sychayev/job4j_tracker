package ru.job4j.tracker;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("A");
        s.add("B");
        s.add("C");
        s.add("D");
        for(String g : s){
            System.out.println(g);
        }

    }
}
