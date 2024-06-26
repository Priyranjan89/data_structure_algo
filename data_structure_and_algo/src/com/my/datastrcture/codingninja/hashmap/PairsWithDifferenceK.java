package com.my.datastrcture.codingninja.hashmap;

import java.util.HashMap;

public class PairsWithDifferenceK {
    public static void main(String[] args) {
        int arr[] = {5,1,2,4};
        int  k = 3;
        System.out.println(getPairsWithDifferenceK(arr,k));
    }
    public static int getPairsWithDifferenceK(int arr[], int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key:arr)
        {
            if(map.containsKey(key))
            {
                map.put(key,map.get(key)+1);
            }
            else
            {
                map.put(key,1);
            }
        }
        int countPairs=0;
        if (k==0)
        {
            for (Integer i: map.keySet())
            {
                int val=map.get(i);
                countPairs=countPairs+(val*(val-1))/2;
            }
            return countPairs;
        }

        for (Integer i: map.keySet())
        {
            if (map.containsKey(k+i))
            {
                countPairs=countPairs+(map.get(i)*map.get(k+i));
            }
            if (map.containsKey(i-k))
            {
                countPairs=countPairs+(map.get(i)*map.get(i-k));
            }
        }
        countPairs=countPairs/2;
        return countPairs;
    }
}
