package ru.job4j.tracker;

public class StubInput implements Input {
    private String [] answers;
    private int position = 0;
    public StubInput(String[]answers){
        this.answers=answers;
    }
    @Override

    public String askStr(String question) {
        return question;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}