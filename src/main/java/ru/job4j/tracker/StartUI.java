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

    public void init(Input in, Tracker track) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(in.askStr("Select menu index:"));
            if (select == 0) {
                CreateItem create = new CreateItem();
                create.name();
                create.execute(in, track);
            } else if (select == 1) {
                ShowItem show = new ShowItem();
                show.name();
                show.execute(in, track);
            } else if (select == 2) {
                ReplaceItem replace = new ReplaceItem();
                replace.name();
                replace.execute(in, track);
            } else if (select == 3) {
                DeleteAction delete = new DeleteAction();
                delete.name();
                delete.execute(in, track);
            } else if (select == 4) {
                FindItem find = new FindItem();
                find.name();
                find.execute(in, track);
            } else if (select == 5) {
                FindItemById findIByName = new FindItemById();
                findIByName.name();
                findIByName.execute(in, track);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Input in = new ConsoleInput();
        Tracker track = new Tracker();
        UserAction[] actions = {
                new CreateAction()
        };
        new StartUI().init(in, track, actions);
    }
}

