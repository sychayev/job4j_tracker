package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ConsoleOutput o = new ConsoleOutput();
        String name = input.askStr("Enter name!");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                o.println(items[i]);
            }
        } else {
            o.println("There is not item like that!!");
        }
        return true;
    }
}
