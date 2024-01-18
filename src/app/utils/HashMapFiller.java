package app.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapFiller<K, V> {

    public HashMap<K, V> fillNewHashMap(ArrayList<K> keys, ArrayList<V> values) {
        HashMap<K, V> newHashMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            newHashMap.put(keys.get(i), values.get(i));
        }

        return newHashMap;
    }
}
