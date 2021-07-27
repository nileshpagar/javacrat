package com.javacrat.dictionary;

import java.util.LinkedList;
import java.util.List;

public class SimpleDictionary<K, V> implements Dictionary<K, V>{

    List<Node<K, V>> values;

    static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public SimpleDictionary() {
        values = new LinkedList<Node<K, V>>();
    }

    public V get(K key) {
        V value = null;
        for (Node<K, V> node : values) {
            if (node.getKey().equals(key)) {
                value = node.getValue();
                break;
            }
        }
        return value;
    }
    public void put(K key, V value) {
        boolean isPresent = false;
        for (Node<K, V> node : values) {
            if (node.getKey().equals(key)) {
                isPresent = true;
                values.remove(node);
                values.add(new Node<>(key, value));
                break;
            }
        }
        if (!isPresent)
            values.add(new Node<>(key, value));
    }

    public void remove(K key) {
        for (Node<K, V> node : values) {
            if (node.getKey().equals(key)) {
                values.remove(node);
                break;
            }
        }
    }

    public int size(){
        return values.size();
    }

}
