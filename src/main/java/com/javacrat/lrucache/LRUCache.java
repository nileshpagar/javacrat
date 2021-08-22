package com.javacrat.lrucache;

import java.time.LocalDateTime;
import java.util.*;

class LRUCache {

    Map<Integer, Value<Integer>> cache;
    private int capacity;
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity, 1.0f);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Value<Integer> value = cache.get(key);
            value.addMetadata(Value.LAST_USED, LocalDateTime.now());
            return value.getData();
        } else return -99999999;
    }

    public void put(int key, int value) {
        if (cache.size() < capacity) {
            cache.put(key, new Value<>(value));
        } else if(cache.size() >= capacity && cache.containsKey(key)) {
            cache.put(key, new Value<>(value));
        } else {
            evictAndPut(key, value);
        }
    }

    private void evictAndPut(int key, int value) {
        int _key = 0;
        LocalDateTime olderDate = LocalDateTime.now();
        for (int currentKey : cache.keySet()) {
            LocalDateTime oldestEntry = (LocalDateTime) cache.get(currentKey).getMetadata(Value.LAST_USED);
            if (oldestEntry.isBefore(olderDate)) {
                olderDate = oldestEntry;
                _key = currentKey;
            }
        }
        cache.remove(_key);
        cache.put(key, new Value<>(value));
    }

    private static class Value<T> {
        public static final String LAST_USED = "LAST_USED";
        private Map<String, Object> metadata = new HashMap<>();
        private T data;
        private Value(T data) {
            this.data = data;
            this.addMetadata(LAST_USED, LocalDateTime.now());
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
