package ru.innopolis.stc12.collections;

import java.util.*;

@Logged
public class MathBox implements MathOperations, ObjectContainer<Integer> {
    private List<Integer> list = new ArrayList<>();

    public MathBox(Set<Integer> values) {
        list.addAll(values);
        sort();
    }

    private void sort() {
        if (list.isEmpty()) return;

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < list.size(); i++) {
                Integer item1 = list.get(i);
                Integer item2 = list.get(i - 1);
                if (item1.compareTo(item2) > 0) {
                    list.set(i, item2);
                    list.set(i - 1, item1);
                    swapped = true;
                }
            }
        } while (!swapped);
    }

    public long summator() {
        if (list.isEmpty()) return 0;

        long result = 0;

        for (Object item : list) {
            result += (Integer) item;
        }

        return result;
    }

    public Set splitter(Integer div) {
        if (div == 0) return new HashSet();

        Set<Double> result = new HashSet<>();

        for (Object item : list) {
            Double divResult = ((Integer) item).doubleValue() / div;
            result.add(divResult);
        }

        return result;
    }


    @Override
    public boolean remove(Integer value) {
        return list.remove(value);
    }

    @Override
    public void add(Integer value) {
        list.add(value);
    }

    @Override
    @ClearData
    public void addAll(Collection values) {
        list.addAll(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "list=" + list +
                '}';
    }
}
