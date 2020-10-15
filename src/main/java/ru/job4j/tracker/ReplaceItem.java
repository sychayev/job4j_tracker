package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item!";
    }

    @Override
    public boolean execute(Input input, Tracker track) {
        int id = input.askInt("Which id");
        String name = input.askStr("Enter id");
        Item item = new Item(name);
        item.setName(name);
        if (track.replace(id, item)) {
            out.println("You replaced item.");
        } else {
            out.println("You did not replace your item!!");
        }
        return true;
    }
}
