package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class TermOfAp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x  = sc.nextInt();
        int ans = 0;
        int i = 1;


        if(x > 1000 || x < 1){
            return;
        }

        while (i <= x){
            ans = (3 * i) + 2;
            if ((ans % 4) != 0){
                System.out.print(ans+" ");
            } else {
                x = x+1;
            }
            i++;
        }
    }
}
