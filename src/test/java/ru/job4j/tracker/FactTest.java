package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenTestEx() {
        Fact.calc(-5);
    }

    @Test
    public void whenCalc2() {
        int rsl = Fact.calc(5);
        assertThat(rsl, is(120));
    }

}