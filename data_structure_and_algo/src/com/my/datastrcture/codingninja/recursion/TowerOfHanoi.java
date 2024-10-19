package com.my.datastrcture.codingninja.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        towerOfHanoi2(n, 'a', 'b', 'c');
    }

 /*   public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {

        if (disks == 0){
            return;
        }
        towerOfHanoi(disks-1, source, destination, auxiliary);
        System.out.println("Move disk "+disks+" from "+source+" "+destination);
        towerOfHanoi(disks-1, auxiliary, source, destination);
    }*/

    public static void towerOfHanoi2(int disks, char source, char auxiliary, char destination) {
        if (disks == 0){
            return;
        }
        towerOfHanoi2(disks-1, source, destination, auxiliary);
        System.out.println("Move disk "+disks+" from  "+ source+" "+destination);
        towerOfHanoi2(disks-1, auxiliary, source, destination);
    }
}
