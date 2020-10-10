package ru.job4j.tracker;

public class StartUI {

    public void init(Input in, Tracker track, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = in.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(in, track);
        }

    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + "." + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input in = new ConsoleInput();
        Tracker track = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new CreateItem(),
                new  ShowItem(),
                new ReplaceItem(),
                new  DeleteAction(),
                new FindItem(),
                new FindItemByName(),
                new ExitAction()
        };
    }
}

