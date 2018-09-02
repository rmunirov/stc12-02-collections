package ru.innopolis.stc12.collections;

import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> array = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array.add(random.nextInt(100));
        }

        System.out.println(array);

        MathBox mathBox = new MathBox(array);
        MathBoxProxy mathBoxProxy = new MathBoxProxy(mathBox);
        Object object = Proxy.newProxyInstance(MathBoxProxy.class.getClassLoader(), MathBox.class.getInterfaces(), mathBoxProxy);
        MathOperations mathOperations = (MathOperations) object;
        ObjectContainer<Integer> objectContainer = (ObjectContainer<Integer>) object;   //TODO this is right?

        System.out.println("Without proxy");
        System.out.println(mathBox);
        System.out.println("summ = " + mathBox.summator());
        System.out.println(mathBox.splitter(5));
        System.out.println(mathBox.remove(23));
        mathBox.addAll(array);
        System.out.println(mathBox);

        System.out.println();

        System.out.println("With proxy");
        System.out.println(mathOperations);
        System.out.println("summ = " + mathOperations.summator());
        System.out.println(mathOperations.splitter(5));
        System.out.println(objectContainer.remove(23));
        objectContainer.addAll(array);
        System.out.println(objectContainer);

    }
}
