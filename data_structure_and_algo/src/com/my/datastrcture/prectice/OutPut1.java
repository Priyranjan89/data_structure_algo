package com.my.datastrcture.prectice;

public class OutPut1 {
    public static void main(String[] args) {

        /*for (int i =0; i <= 5; i++){
            System.out.println(i+" ");
            i++;
        }*/

        /*for (int i =0; i <= 15; i += 2){
            System.out.println(i+" ");
            if (i & 1){
                continue;
            }
            i++;
        }*/
        for (int i =0; i < 5; i++){
            for (int j = i; j<=5; j++){
                if(i+j == 10){
                    break;
                }
                System.out.println(i+" "+j);
            }
        }
    }
}
