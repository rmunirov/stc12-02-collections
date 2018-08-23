package ru.innopolis.stc12.collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set array = new HashSet();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array.add(random.nextInt(100));
        }

        System.out.println(array);

        MathBox mathBox = new MathBox(array);

        System.out.println(mathBox);

        System.out.println(mathBox.summator());

        System.out.println(mathBox.splitter(5));

        System.out.println(mathBox.remove(23));

        System.out.println(mathBox.remove(((Integer) array.iterator().next())));
    }
}
