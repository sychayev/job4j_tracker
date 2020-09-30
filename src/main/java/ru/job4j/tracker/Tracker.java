package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] rsl = new Item[size];
        for (int i = items.length; i < size; i++) {
            if (items[i].getName().equals(key)) {
                rsl[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }


    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items[i] : null;
    }

    public boolean replace(int id, Item bugWithDesc) {
        int in = indexOf(id);
        boolean ret = false;
        if (in != -1) {
            bugWithDesc.setId(id);
            items[in] = bugWithDesc;
            ret = true;
        }
        return ret;
    }

    public boolean delete(int id) {
        items[indexOf(id)] = null;
        boolean res = false;
        if (items[id] == null) {
            Item it = new Item();
            it.setId(id);
            int start = it + 1;
            int distPost = it;
            int length = size - it;
            items[size - 1] = null;
            System.arraycopy(items[id],start,distPost,items[],length);
            size--;
            res = true;
        }
        return res;
    }
}