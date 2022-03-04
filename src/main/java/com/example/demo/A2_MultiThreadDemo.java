package com.example.demo;

public class A2_MultiThreadDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("T1"));
        Thread t2 = new Thread(new MyThread("T2"));
        Thread t3 = new Thread(new MyThread("T3"));
        Thread t4 = new Thread(new MyThread("T4"));
        Thread t5 = new Thread(new MyThread("T5"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println("All Threads finished processing!!");
            t5.start();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println("Main Thread Completed!!");
    }
}

class MyThread implements Runnable {

    private final String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println("Running... Thread: " + name);
        for (int i = 0; i < 3; i++) {
            //System.out.println("Thread: " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception in MyThread: " + name);
            }
        }
        System.out.println("Stopped!! Thread: " + name);
    }
}