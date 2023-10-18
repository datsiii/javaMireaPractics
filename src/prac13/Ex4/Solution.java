package prac13.Ex4;


import java.util.*;

public class Solution<T, K, V> {
    private List<T> list;
    private Set<T> set;
    private HashMap<K, V> map;

    public Solution() {
        list = new ArrayList<>();
        set = new HashSet<>();
        map = new HashMap<>();
    }

    public void addToArrayList(T element) {
        list.add(element);
    }

    public void addToHashSet(T element) {
        set.add(element);
    }

    public void addToHashMap(K key, V value) {
        map.put(key, value);
    }

    @SafeVarargs
    public static <T> List<T> newArrayList(T... elements) {
        return new ArrayList<>(List.of(elements));
    }

    @SafeVarargs
    public static <T> Set<T> newHashSet(T... elements) {
        return new HashSet<>(Set.of(elements));
    }

    public List<T> getList() {
        return list;
    }

    public Set<T> getSet() {
        return set;
    }

    public HashMap<K, V> getMap() {
        return map;
    }

    public static <K, V> HashMap<K, V> newHashMap(K[] keys, V[] values) {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Keys and values arrays must have the same length.");
        }

        HashMap<K, V> hashMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], (V) values[i]);
        }
        return hashMap;
    }

}

