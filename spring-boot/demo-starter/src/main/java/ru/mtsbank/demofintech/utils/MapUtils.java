package ru.mtsbank.demofintech.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtils {
    public static <V> void putInMap(Map<String, List<V>> map, V elem) {
        String key = elem.getClass().getName();
        List<V> list = map.get(key);
        if (list == null) {
            List<V> arrayList = new ArrayList<>();
            map.put(key, arrayList);
        }
        else list.add(elem);
    }

    public static <T> void increment(Map<T, Integer> map, T key) {
        if (map.containsKey(key)) map.put(key, map.get(key) + 1);
        else map.put(key, 1);
    }


}
