package com.my.datastrcture.prectice.hashMap;

import java.util.ArrayList;

public class CustomMap<K, V> {
    private ArrayList<MapNode<K, V>> buckets;
    int count;
    int numOfBuckets;

    public CustomMap() {
        buckets = new ArrayList<>();
        numOfBuckets = 5;
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(null);
        }
    }

    public int size() {
        return count;
    }

    private int getBucketIndex(K key) {
        int hc = key.hashCode();
        int index = hc % numOfBuckets;
        return index;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (1.0 * count) / numOfBuckets;
        if (loadFactor > 0.7) {
            reHash();
        }
    }

    public double loadFactor(){
        return (1.0 * count) / numOfBuckets;
    }

    private void reHash() {
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * numOfBuckets; i++) {
            buckets.add(null);
        }

        count = 0;
        numOfBuckets = 2 * numOfBuckets;

        for (int i = 0; i < temp.size(); i++) {

            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }

    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {

                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
}
