package ru.job4j.tracker;

public class ShowItem implements UserAction {
    private final Output out;

    public ShowItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ConsoleOutput o = new ConsoleOutput();
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            o.println(items[i]);
        }
        return true;
    }
}
