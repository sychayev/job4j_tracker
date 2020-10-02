package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenFindAll() {
        Tracker track = new Tracker();
        Item item = new Item();
        track.add(item);
        Item[] res = track.findAll();
        assertThat(res[0].getName(),is(item.getName()));
    }

    @Test
    public void whenFindById() {
        Tracker track = new Tracker();
        Item item = new Item();
        item.setId(2);
        track.add(item);
        Item[] res = track.findById(item.getId());
        assertThat(res[0].getName(),is(item.getName()));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test

    public void whenFindByName() {
        Tracker track = new Tracker();
        Item it = new Item();
        it.setName("A");
        track.add(it);
        String key = it.getName();
        track.findByName(key);
        assertThat(track.findByName(key)[0].getName(), is("A"));
    }

    @Test
    public void whenReplace() {

        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
