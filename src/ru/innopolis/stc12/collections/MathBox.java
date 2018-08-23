package ru.innopolis.stc12.collections;

import java.util.*;

public class MathBox {
    private List list = new ArrayList();

    public MathBox(Set<Integer> values) {

        for (Integer item : values) {
            list.add(item);
        }

        sort();
    }

    private void sort() {
        if (list.isEmpty()) return;

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < list.size(); i++) {
                Integer item1 = (Integer) list.get(i);
                Integer item2 = (Integer) list.get(i - 1);
                if (item1.compareTo(item2) > 0) {
                    list.set(i, item2);
                    list.set(i - 1, item1);
                    swapped = true;
                }
            }
        } while (swapped != false);
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

        Set result = new HashSet();

        for (Object item : list) {
            Double divResult = ((Integer) item).doubleValue() / div;
            result.add(divResult);
        }

        return result;
    }

    public boolean remove(Integer value) {
        return list.remove(value);
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
