package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest  {
    @Test
    public void whenAddItem(){
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input,tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(),is(expected));
    }
    @Test
    public void whenCreateItem(){
        String[] answers = {"=== Create a new Item ===="};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input,tracker);
        String name = input.askStr("Enter id");
        Item item = new Item(name);
        Item created = tracker.add(item);
        Item expected = new Item("=== Create a new Item ====");
        assertThat(created.getName(),is(expected));
    }
}