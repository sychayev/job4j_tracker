package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI extends  Tracker{

    public void init (Scanner in ,Tracker track){
        boolean run= true;
        while(run){
            this.showMenu();
            int select = Integer.valueOf(in.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = in.nextLine();
                Item item = new Item();
                track.add(item);
            }else if(select == 1){
                System.out.println(" Show all items");
                String name = in.nextLine();
                Item item = new Item();
                track.findAll();
            }else if(select == 2){
                System.out.println("Edit item");
                int id = in.nextInt();
                Item item = new Item();
//                track.replace (name,item);
                if(track.replace(id,item)){
                    System.out.println("You replaced item.");
                }else{
                    System.out.println("You did not replace your item!!");
                }
            }else if(select == 3){
                System.out.println("Delete item");
                int i = in.nextInt();
                boolean id = in.nextBoolean();
                track.delete(1);
                track.findById(i);
                if (i != 0 ){
                    track.delete(1);
                }else{
                    track.delete(0);
                }
            }else if(select == 4){
                System.out.println("Find item by Id");
                int id  = in.nextInt();
                track.findById(id);
            }else if(select == 5){
                System.out.println("Find items by name");
                String name = in.nextLine();
                track.findByName(name);
            }else if(select == 6){
                run = false;
            }
        }
    }
    private void showMenu(){
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
       Scanner in = new Scanner(System.in);
       Tracker track = new Tracker();
       new StartUI().init(in,track);


    }
}

