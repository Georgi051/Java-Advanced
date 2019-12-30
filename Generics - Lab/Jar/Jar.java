package Generics.Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> storage;

    public Jar() {
        this.storage = new ArrayDeque<>();
    }

    public void add(T element) {
        storage.push(element);
    }

    public T remove() {
        return storage.pop();
    }
}
