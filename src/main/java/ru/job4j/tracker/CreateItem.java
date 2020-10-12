package ru.job4j.tracker;

public class CreateItem implements UserAction{

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker track) {
        String name = input.askStr("Enter id");
        Item item = new Item(name);
        track.add(item);
        return false;
    }
}
