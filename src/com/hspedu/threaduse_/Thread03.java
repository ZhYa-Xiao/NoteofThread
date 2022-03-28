package com.hspedu.threaduse_;

public class Thread03 {
    public static void main(String[] args) {
        Hello hello = new Hello();
        Hi hi = new Hi();
        hello.start();
        hi.start();
    }
}

class Hi extends Thread {
    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hello extends Thread {
    @Override
    public void run() {
        System.out.println("hello,world");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}