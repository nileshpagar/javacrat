package com.javacrat.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    Map<Integer, Value<Integer>> cache;
    LinkedList<Integer> lru;
    private int capacity;
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity, 1.0f);
        this.capacity = capacity;
        this.lru = new LinkedList<Integer>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Value<Integer> value = cache.get(key);
            touch(key);
            return value.getData();
        } else return -99999999;
    }

    private void touch(int key) {
        int indexOf = lru.indexOf(key);
        if (indexOf != -1) {
            lru.remove(indexOf);
            lru.addFirst(key);
        }
    }

    public void put(int key, int value) {
        if (cache.size() < capacity) {
            cache.put(key, new Value<>(value));
        } else if(cache.size() >= capacity && cache.containsKey(key)) {
            cache.put(key, new Value<>(value));
        } else {
            evictAndPut(key, value);
        }
        register(key);
    }

    private void register(int key) {
        int indexOf = lru.indexOf(key);
        if (indexOf != -1) {
            lru.remove(indexOf);
            lru.addFirst(key);
        } else {
            lru.addFirst(key);
        }
    }

    private void evictAndPut(int key, int value) {
        Integer last = lru.getLast();
        if(cache.containsKey(last)) {
            cache.remove(last);
            lru.removeLast();
        } else throw new RuntimeException("Not able to evict older keys. Please check");
        put(key, value);
    }

    private static class Value<T> {
        private Map<String, Object> metadata = new HashMap<>();
        private T data;
        private Value(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }
        public Map getMetadata() {
            return this.metadata;
        }
        public void addMetadata(String key, Object value) {
            this.metadata.put(key, value);
        }
        public Object getMetadata(String key) {
            return this.metadata.get(key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(6, 6);
        lruCache.get(3);
        lruCache.put(7, 7);
    }

}
