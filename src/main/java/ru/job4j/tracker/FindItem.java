package ru.job4j.tracker;

public class FindItem implements  UserAction{
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id!");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        }else {
            System.out.println("There is not item with this id!");
        }
        return true;
    }
}
