package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;


public class RemoveElementWithoutErrorsTest{

    public List<Integer> list;


    @BeforeEach
    public void initEach() {
        list = new ArrayList<>(Arrays.asList(1, 2, 3));
    }


    @Test
    public void successConcurrentModificationException() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {
            
            for (Integer integer : list) {
                list.remove(1);
            }
            
        });
    }

    @Test
    public void successRemoveElementWithoutErrors() {

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
                Integer value = iterator.next();
                if (value == 2) {
                    iterator.remove();
                }
            }

        assertFalse(list.contains(2));
    }

    @Test
    public void successRemoveElementWithoutErrors2() {

        List<Integer> newList = new ArrayList<>();

        for (Integer value : list) {
            if (value == 3) {
                newList.add(value);
            }
        }

        list.removeAll(newList);
        assertFalse(list.contains(3));

    }

    @Test
    public void successRemoveElementWithoutErrors3() {

        list.removeIf(value -> value == 1);
        assertFalse(list.contains(1));

    }

    @Test
    public void successRemoveElementWithoutErrors4() {

        List<String> collected = list.stream()
                .filter(value -> value != 2)
                .map(Object::toString)
                .collect(toList());

        assertFalse(collected.contains("2"));
        assertTrue(collected.contains("1"));
        assertTrue(collected.contains("3"));

    }

}
