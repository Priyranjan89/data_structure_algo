package com.my.datastrcture.codingninja.hashmap;

import java.util.ArrayList;

public class CustomMap<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    public CustomMap() {
        this.buckets = new ArrayList<>();
        numBuckets = 5;
        for(int i=0;i<numBuckets;i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hc = key.hashCode();
        int index = hc%numBuckets;
        return index;
    }

    public int size(){
        return count;
    }

    public double loadFactor(){
        return (1.0* count)/numBuckets;
    }
    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        // element is not there? just update the value

        while (head != null){
            if (head.key.equals(key)){
                head.value = value;
            }
            head = head.next;
        }
        //Element is not there, insert at 0th position of linked list
        head =buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (1.0* count)/numBuckets;
        if(loadFactor> 0.7) {
            reHash();
        }

    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;

        while (head != null){
            if (head.key.equals(key)){
                V temp = head.value;
                if (prev != null){
                    prev.next = head.next;
                }else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return temp;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);

        while (head != null){
            if (head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    private void reHash() {
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null);
        }
        count = 0;
        numBuckets = numBuckets * 2;
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


}
