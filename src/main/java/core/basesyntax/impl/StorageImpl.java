package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] array = new Object[ARRAY_SIZE * 2];
    private int iterator = 0;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < array.length; i += 2) {
                if (key == array[i] || (key != null && key.equals(array[i]))) {
                    array[i + 1] = value;
                    break;
                }
            }
        } else {
            if (size <= ARRAY_SIZE) {
                array[iterator++] = key;
                array[iterator++] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < array.length; i += 2) {
            if (key == array[i] || (key != null && key.equals(array[i]))) {
                return (V) array[i + 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
