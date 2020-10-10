package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return    "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker track) {
        int n = input.askInt("Enter item");
        track.findById(n);
        if (track.delete(n)) {
            System.out.println("Find deleted this item");
        } else {
            System.out.println("You did not delete this item!");
        }
        return true;
    }
}
