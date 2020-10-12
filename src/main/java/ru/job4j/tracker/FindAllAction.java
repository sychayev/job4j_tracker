package ru.job4j.tracker;

import java.util.Arrays;

public class FindAllAction implements UserAction{
    private final Output out;
    private static final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public FindAllAction (Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Arrays.copyOf(items, size);
         return true;
    }
}
