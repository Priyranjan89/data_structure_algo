package com.my.datastrcture.interview;

public class ThreadTest {
    static int counter = 1;
    static int num;

    public void printOddNumber(){
        synchronized (this){
            while (counter < num){
                if (counter % 2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                System.out.print(counter+" ");
                counter++;
                notify();
            }
        }
    }

    public void printEvenNumber(){
        synchronized (this){
            while (counter < num){
                if (counter % 2 == 1){
                    try {
                        wait();
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                System.out.print(counter+" ");
                counter++;
                notify();
            }
        }
    }
    public static void main(String[] args) {
        num = 20;
        ThreadTest threadTest = new ThreadTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest.printOddNumber();
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest.printEvenNumber();
            }
        });

        t1.start();
        t2.start();
    }
}
