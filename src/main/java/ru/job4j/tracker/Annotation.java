package ru.job4j.tracker;

public class Annotation extends Tracker {
    private Tracker track;

    @Override
    public boolean replace(int id, Item bugWithDesc) {
//        return super.replace(id, bugWithDesc);
        int in = track.indexOf(id);
        boolean rsl = in != -1;
        if (rsl) {
            items[in] = bugWithDesc;
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }
}