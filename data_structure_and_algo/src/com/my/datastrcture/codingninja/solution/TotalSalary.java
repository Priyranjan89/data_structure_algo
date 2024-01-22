package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class TotalSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baseSalary = sc.nextInt();
        String str = sc.next();
        char ch = str.charAt(0);
        float hra = ((float)20 / 100) * baseSalary;
        float da = ((float)50 / 100) * baseSalary;
        float pf = ((float)11 / 100) * baseSalary;

        float salary = 0.0f;

        switch (ch){
            case 'A':
                salary = (baseSalary+hra+da+1700)-pf;
                break;
            case 'B':
                salary = (baseSalary+hra+da+1500)-pf;
                break;
            default:
                salary = (baseSalary+hra+da+1300)-pf;
        }

        int ans  = Math.round(salary);
        System.out.println(ans);
    }
}
