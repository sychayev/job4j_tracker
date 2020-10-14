package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    private final Output out;
    public FindByIdAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find all action items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        return true;
    }
}
