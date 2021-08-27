package com.javacrat;

import java.util.*;

public class TopKInJava {

    public static void main(String[] args) {
        List<String> events = new ArrayList<>();
        events.add("one");events.add("two");events.add("two");events.add("three");events.add("three");
        events.add("three");events.add("four");events.add("four");events.add("four");events.add("four");
        events.add("five");events.add("five");events.add("five");events.add("five");events.add("five");
        events.add("six");events.add("six");events.add("six");events.add("six");events.add("six");
        events.add("six");events.add("seven");events.add("seven");events.add("seven");events.add("seven");
        events.add("seven");events.add("seven");events.add("seven");events.add("eight");events.add("eight");
        events.add("eight");events.add("eight");events.add("eight");events.add("eight");events.add("eight");events.add("eight");
        System.out.println(topK(events, 2));
    }

    public static List<HeavyHitter> topK(List<String> events, int k){
        List<HeavyHitter> result = new ArrayList<>();

        Map<String, Integer> frequencyTable = new HashMap<>();
        for (String event : events ) {
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }

        PriorityQueue<HeavyHitter> heap = new PriorityQueue<HeavyHitter>(Comparator.comparing(e -> e.getFrequency()));
        for (Map.Entry<String, Integer> entry : frequencyTable.entrySet()) {
            heap.offer(new HeavyHitter(entry.getKey(), entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        result.addAll(heap);

        return result;
    }

}



class HeavyHitter {
    private final String id;
    private final int frequency;
    public HeavyHitter(String id, int frequency){
        this.id = id;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return id + "=" + frequency;
    }
}
