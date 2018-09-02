package ru.innopolis.stc12.collections;

import java.util.Collection;

public interface ObjectContainer<T> {
    boolean remove(T value);

    void add(T value);

    @ClearData
        //TODO when i added this annotation in MathBox class and called method, then proxy don't found it
    void addAll(Collection values);
}
