package app.controller;

import java.util.HashMap;

public class HashMapFiller<K, V> {

    public HashMap<K, V> fillNewHashMap(K[] keys, V[] values) {
        HashMap<K, V> newHashMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            newHashMap.put(keys[i], values[i]);
        }

        return newHashMap;
    }
}
