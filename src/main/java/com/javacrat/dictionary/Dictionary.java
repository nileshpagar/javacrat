package com.javacrat.dictionary;

public interface Dictionary<K, V> {
    public V get(K key);
    public void put(K key, V value);
    public void remove(K key);
    public int size();
}
