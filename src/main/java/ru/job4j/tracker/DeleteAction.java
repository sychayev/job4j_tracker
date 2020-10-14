package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction (Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return    "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker track) {
        ConsoleOutput o = new ConsoleOutput();
        int n = input.askInt("Enter item");
        if (track.delete(n)) {
            o.println("Find deleted this item");
        } else {
            o.println("You did not delete this item!");
        }
        return true;
    }
}
