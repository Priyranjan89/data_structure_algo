package com.my.datastrcture.prectice.priorityqueue;

import java.util.ArrayList;

public class PQ {
    private ArrayList<Integer> heap;

    public PQ(){
        heap = new ArrayList<>();
    }
    boolean isEmpty() {
        return heap.size() == 0;
    }

    int getSize() {
        return heap.size();
    }

    int getMax() {
        if(isEmpty())
            return Integer.MIN_VALUE;
        return heap.get(heap.size()-1);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMax() {
        if(isEmpty())
            return Integer.MIN_VALUE;
        int lchildindex=1;
        int rchildindex=2;
        int parentindex=0;
        int maxindex=parentindex;
        int temp=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        while(lchildindex<heap.size()){
            if(heap.get(lchildindex)>heap.get(parentindex))
                maxindex=lchildindex;
            if(rchildindex<heap.size() && heap.get(rchildindex)>heap.get(maxindex))
                maxindex=rchildindex;
            if(maxindex==parentindex)
                break;
            else{
                int temp1=heap.get(parentindex);
                heap.set(parentindex,heap.get(maxindex));
                heap.set(maxindex,temp1);
                parentindex=maxindex;
                lchildindex=2*parentindex +1;
                rchildindex=2*parentindex +2;

            }
        }
        return temp;
    }
}
