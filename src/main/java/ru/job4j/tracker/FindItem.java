package ru.job4j.tracker;

public class FindItem implements  UserAction{
    private final Output out;

    public FindItem (Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ConsoleOutput o = new ConsoleOutput();
        int id = input.askInt("Enter id!");
        Item item = tracker.findById(id);
        if (item != null) {
            o.println(item);
        }else {
            o.println("There is not item with this id!");
        }
        return true;
    }
}
