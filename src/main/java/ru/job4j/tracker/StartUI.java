package ru.job4j.tracker;

public class StartUI extends Tracker {
    public void init(Input in, Tracker track) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(in.askStr("Select menu index:"));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String msg = "Enter id";
                String name = in.askStr(msg);
                Item item = new Item();
                track.add(item);
            } else if (select == 1) {
                System.out.println(" Show all items");
                track.findAll();
            } else if (select == 2) {
                System.out.println("Edit item");
                String msg = "Enter id";
                int id = in.askInt(msg);
                Item item = new Item();
                String name = in.askStr(msg);
                item.setName(name);
                if (track.replace(id, item)) {
                    System.out.println("You replaced item.");
                } else {
                    System.out.println("You did not replace your item!!");
                }
            } else if (select == 3) {
                System.out.println("Delete item");
                String msg = "Enter item";
                int i = in.askInt(msg);
                track.findById(i);
                if (track.delete(i)) {
                    System.out.println("Find deleted this item");
                } else {
                    System.out.println("You did not delete this item!");
                }
            } else if (select == 4) {
                System.out.println("Find item by Id");
                String msg = "Enter id!";
                int id = in.askInt(msg);
                track.findById(id);
            } else if (select == 5) {
                System.out.println("Find items by name");
                String msg = "Enter name!";
                String name = in.askStr(msg);
                track.findByName(name);
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
        new StartUI().init(in, track);


    }
}

