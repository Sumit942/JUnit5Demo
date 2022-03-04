package com.example.demo;

public class A2_MultiThreadDemo {

    public static void main(String[] args) {

        Runnable r = () -> {
            System.out.println("Running Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Exception: Thread " + Thread.currentThread().getName());
            }
            System.out.println("Stopped Thread: " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(r,"T1");
        Thread t2 = new Thread(r,"T2");
        Thread t3 = new Thread(r, "T3");
        Thread t4 = new Thread(r, "T4");
        Thread t5 = new Thread(r, "T5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println("All 4 Threads finished processing!!");
            t5.start();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Exception in Thread join: " + e.getMessage());
        }
    }
}