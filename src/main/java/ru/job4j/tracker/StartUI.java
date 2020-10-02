package ru.job4j.tracker;

public class StartUI extends Tracker {

    public void init(Input in, Tracker track) {
        boolean run = true;
        while (run) {
            this.showMenu();
            String msg = "Enter id";
            int select = Integer.valueOf(in.askStr(msg));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = in.askStr(msg);
                Item item = new Item();
                track.add(item);
            } else if (select == 1) {
                System.out.println(" Show all items");
                String name = in.askStr(msg);
                track.findAll();
            } else if (select == 2) {
                System.out.println("Edit item");
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
                int i = in.askInt(msg);
//                boolean id = in.nextBoolean();
                track.delete(1);
                track.findById(i);
                if (i != 0) {
                    track.delete(1);
                } else {
                    track.delete(0);
                }
            } else if (select == 4) {
                System.out.println("Find item by Id");
                int id = in.askInt(msg);
                track.findById(id);
            } else if (select == 5) {
                System.out.println("Find items by name");
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

