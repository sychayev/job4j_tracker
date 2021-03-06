package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        String s = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item i = new Item("item");
        Input in = new StubInput(new String[]{"0",
                String.valueOf(i.getId()),
                "1"});
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(("Menu") + s +
                ("0.=== Create a new Action ====") + s +
                ("1.Exit") + s +
                ("Menu") + s +
                ("0.=== Create a new Action ====") + s +
                ("1.Exit") + s));

    }

    @Test
    public void whenFindItemByName() {
        String s = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item i = new Item("item");
        Input in = new StubInput(new String[]{"0",
                String.valueOf(i.getId()),
                "1"});
        UserAction[] actions = {
                new FindItemByName(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(("Menu") + s +
                ("0.Find items by name") + s +
                ("1.Exit") + s +
                ("There is not item like that!!") + s +
                ("Menu") + s +
                ("0.Find items by name") + s +
                ("1.Exit") + s));

    }

    @Test
    public void whenReplaceItem() {
        String s = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(("Menu") + s +
                ("0.Edit item!") + s +
                ("1.Exit") + s +
                ("You replaced item.") + s +
                ("Menu") + s +
                ("0.Edit item!") + s +
                ("1.Exit") + s));
    }

    @Test
    public void whenShowItems() {
        String s = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Show items"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "3"}
        );
        UserAction[] actions = {
                new ShowItem(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(("Menu") + s +
                ("0. Show all items") + s +
                ("1.Exit") + s +
                ("Item{id=1, name='Show items'}") + s +
                ("Menu") + s +
                ("0. Show all items") + s +
                ("1.Exit") + s));
    }

    @Test
    public void whenFindByIdAction() {
        String s = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find by id action item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(("Menu") + s +
                ("0.Find item by id!") + s +
                ("1.Exit") + s +
                ("Item{id=1, name='Find by id action item'}") + s +
                ("Menu") + s +
                ("0.Find item by id!") + s +
                ("1.Exit") + s));

    }

    @Test
    public void whenDeleteItem() {
        String s = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(("Menu") + s +
                ("0.Delete item") + s +
                ("1.Exit") + s +
                ("Find deleted this item") + s +
                ("Menu") + s +
                ("0.Delete item") + s +
                ("1.Exit") + s));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();

        Input in = new StubInput(
                new String[]{"0","1"}
        );
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }

}

