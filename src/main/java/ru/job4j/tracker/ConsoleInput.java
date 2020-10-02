package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input{
    private Scanner in = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}
