package com.company;

import java.util.Comparator;

public class CompareName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }

}
