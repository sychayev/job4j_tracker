package ru.job4j.tracker;

public class StartUI extends Tracker {
    Item it[] = items;
    public static void createItem(Input input, Tracker track) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter id");
        Item item = new Item(name);
        track.add(item);
    }

    public static void showItem(Input input, Tracker track) {
        System.out.println(" Show all items");
        track.findAll();
    }

    public static void replaceItem(Input input, Tracker track) {
        System.out.println("Edit item!");
        int id = input.askInt("Which id");
        String name = input.askStr("Enter id");
        Item item = new Item(name);
        item.setName(name);
        if (track.replace(id, item)) {
            System.out.println("You replaced item.");
        } else {
            System.out.println("You did not replace your item!!");
        }
    }

    public static void deleteItem(Input input, Tracker track) {
        System.out.println("Delete item");
        int n = input.askInt("Enter item");
        track.findById(n);
        if (track.delete(n)) {
            System.out.println("Find deleted this item");
        } else {
            System.out.println("You did not delete this item!");
        }
    }

    public static void findItem(Input input, Tracker track) {
        System.out.println("Find item by Id");
        int id = input.askInt("Enter id!");
        track.findById(id);
    }

    public static void findItemByName(Input input, Tracker track) {
        System.out.println("Find items by name");
        String name = input.askStr("Enter name!");
        track.findByName(name);
    }

    public void init(Input in, Tracker track) {
        boolean run = true;
        Item it[] = items;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(in.askStr("Select menu index:"));
            if (select == 0) {
                StartUI.createItem(in, track);
            } else if (select == 1) {
                StartUI.showItem(in, track);
            } else if (select == 2) {
                StartUI.replaceItem(in, track);
            } else if (select == 3) {
                StartUI.deleteItem(in, track);
            } else if (select == 4) {
                StartUI.findItem(in, track);
            } else if (select == 5) {
                StartUI.findItemByName(in, track);
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

