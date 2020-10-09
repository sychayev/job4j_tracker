package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest  {

    @Test
    public void whenCreateItem(){
        Input in = new StubInput(new String[]{"0",
        "Item name","1"});
        Tracker tracker = new Tracker ();
        UserAction[] actions = {
                new CreateAction(),
//                new Exit()
        };
        new StartUI().init(in,tracker,actions);
        assertThat(tracker.findAll()[0].getName(),is("item"));
    }

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

    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
               String.valueOf("A"), item.getId() + "C"
        };

        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String [] deletedItems = {
                String.valueOf(item.getId())+"b"
        };
        StartUI.deleteItem(new StubInput(deletedItems), tracker);
        Item delet = tracker.findById(item.getId());
        assertThat(delet.getName(), is(delet));
    }
}