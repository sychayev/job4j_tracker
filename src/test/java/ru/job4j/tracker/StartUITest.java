package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static sun.jvm.hotspot.runtime.VMOps.Exit;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0",
                "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("item"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0","Replace item","1"}
        );
        UserAction[] actions = {
                new ReplaceItem(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        item.getId();
        Input in = new StubInput(
                new String[]{"0","Which delete item", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new Exit()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
//    @Test
//    public void whenAddItem() {
//        String[] answers = {"Fix PC"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.creteItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("Fix PC");
//        assertThat(created.getName(), is(expected));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {
//                String.valueOf( item.getId()),String.valueOf("C")
//        };
//        StartUI.replaceItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(), is("C"));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] deletedItems = {
//                String.valueOf(item.getId())
//        };
//        StartUI.deleteItem(new StubInput(deletedItems), tracker);
//        Item delet = tracker.findById(item.getId());
//        assertThat(delet , is(nullValue()));
//    }
}

